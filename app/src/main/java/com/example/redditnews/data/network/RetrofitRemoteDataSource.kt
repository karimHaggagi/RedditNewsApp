package com.example.redditnews.data.network

import com.example.redditnews.core.data.safeCall
import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.data.ApiService
import com.example.redditnews.data.dto.NewsDTO
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
class RetrofitRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    RemoteDataSource {
    override suspend fun getNews(): Result<NewsDTO, DataError.Remote> {
        return safeCall {
            apiService.getNews()
        }
    }
}