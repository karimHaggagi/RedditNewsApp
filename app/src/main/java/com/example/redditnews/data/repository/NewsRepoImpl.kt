package com.example.redditnews.data.repository

import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.core.domain.map
import com.example.redditnews.data.dto.asNewsDomainModel
import com.example.redditnews.data.network.RemoteDataSource
import com.example.redditnews.domain.model.NewsDomainModel
import com.example.redditnews.domain.repo.NewsRepo
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
class NewsRepoImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : NewsRepo {
    override suspend fun getNews(): Result<List<NewsDomainModel>, DataError.Remote> {
        return remoteDataSource.getNews().map { it.asNewsDomainModel() }
    }

}