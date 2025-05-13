package com.example.redditnews.data.repository

import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.core.domain.onError
import com.example.redditnews.core.domain.onSuccess
import com.example.redditnews.data.local.db.LocalDataSource
import com.example.redditnews.data.remote.dto.asNewsDomainModel
import com.example.redditnews.data.remote.dto.asNewsEntity
import com.example.redditnews.data.remote.network.RemoteDataSource
import com.example.redditnews.domain.model.NewsDomainModel
import com.example.redditnews.domain.repo.NewsRepo
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
                    send(Result.Error(DataError.Local.DISK_FULL))
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