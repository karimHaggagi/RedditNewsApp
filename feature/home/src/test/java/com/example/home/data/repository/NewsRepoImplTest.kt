package com.example.home.data.repository

import app.cash.turbine.test
import com.example.core.data.local.db.entity.NewsEntity
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.home.createFakeNewsDTO
import com.example.home.data.asNewsEntity
import com.example.home.data.local.LocalDataSource
import com.example.home.data.remote.network.RemoteDataSource
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class NewsRepoImplTest {


    private lateinit var SUT: NewsRepoImpl

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setUp() {
        SUT = NewsRepoImpl(remoteDataSource, localDataSource)
    }

    @Test
    fun `Successful remote data fetch and local caching`() = runTest {
        // Test that when remoteDataSource.getNews() returns a successful result,
        successfulRemoteFetch()
        //  localDataSource.addNews() is called with the correctly mapped data,
        addNewsToLocalDB()
        //
        // and subsequently, localDataSource.getLatestNews() is called and its result
        getCashedNews()
        // (mapped to domain models) is emitted as a Result.Success via the channel.

        SUT.getNews().test {
            val result = awaitItem()
            assert(result is Result.Success)
            awaitComplete()
        }

    }

    @Test
    fun `Remote data fetch error`() = runTest {
        // Test that when remoteDataSource.getNews() returns an error result,
        failRemoteFetch()
        // localDataSource.addNews() is NOT called, and the error from the remote data source
        // is emitted as a Result.Error via the channel.

        SUT.getNews().test {
            val result = awaitItem()
            assert(result is Result.Error)
            awaitComplete()
        }
    }

    @Test
    fun `Local data caching error  disk full `() = runTest {
        // Test that when remoteDataSource.getNews() returns a successful result,
        successfulRemoteFetch()
        // but localDataSource.addNews() throws an Exception (simulating disk full),
        failAddToLocalDB()
        // a Result.Error with DataError.Local.DISK_FULL is emitted via the channel,
        // and localDataSource.getLatestNews() is still called.

        SUT.getNews().test {
            val result = awaitItem()
            assert(result is Result.Error)
            awaitComplete()
        }
    }


    @Test
    fun `Local data availability without remote fetch`() = runTest {
        // Test that if remoteDataSource.getNews() encounters an error,
        failRemoteFetch()
        // localDataSource.getLatestNews() is still called and its available data (mapped to domain models)
        getCashedNews()
        // is emitted as a Result.Success.
        SUT.getNews().test {
            val remoteResult = awaitItem()
            assert(remoteResult is Result.Error)

            val localResult = awaitItem()
            assert(localResult is Result.Success)

            awaitComplete()
        }
    }

    private suspend fun successfulRemoteFetch() {
        whenever(remoteDataSource.getNews()).then {
            Result.Success(createFakeNewsDTO())
        }
    }

    private suspend fun failRemoteFetch() {
        whenever(remoteDataSource.getNews()).then {
            Result.Error(DataError.Remote.UNKNOWN)
        }
        whenever(localDataSource.getLatestNews()).then { emptyFlow<List<NewsEntity>>() }
    }

    private fun getCashedNews() {
        whenever(localDataSource.getLatestNews()).then {
            flow {
                emit(createFakeNewsDTO().asNewsEntity())
            }
        }
    }

    private suspend fun addNewsToLocalDB() {
        whenever(localDataSource.addNews(any())).thenReturn(Unit)
    }

    private suspend fun failAddToLocalDB() {
        whenever(localDataSource.addNews(any())).thenThrow(RuntimeException())
        whenever(localDataSource.getLatestNews()).then { emptyFlow<List<NewsEntity>>() }

    }

}