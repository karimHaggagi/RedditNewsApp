package com.example.home.data.repository

import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.onError
import com.example.core.domain.onSuccess
import com.example.home.data.local.LocalDataSource
import com.example.home.data.remote.network.RemoteDataSource
import com.example.home.data.asNewsDomainModel
import com.example.home.data.asNewsEntity
import com.example.core.domain.model.NewsDomainModel
import com.example.home.domain.repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
class NewsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NewsRepo {
    override suspend fun getNews(): Flow<Result<List<NewsDomainModel>, DataError>> = channelFlow {
        remoteDataSource.getNews()
            .onSuccess {
                try {
                    localDataSource.addNews(it.asNewsEntity())
                } catch (e: Exception) {
                    send(Result.Error(com.example.core.domain.DataError.Local.DISK_FULL))
                }
            }
            .onError { send(Result.Error(it)) }

        localDataSource.getLatestNews()
            .map { news ->
                news.map { it.asNewsDomainModel() }
            }.collectLatest {
                send(Result.Success(it))
            }

    }

}