package com.example.home.data.remote.network

import com.example.core.data.remote.safeCall
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.home.data.remote.dto.NewsDTO
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