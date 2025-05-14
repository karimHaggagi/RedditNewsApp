package com.example.home.data.remote.network

import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.home.data.remote.dto.NewsDTO

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
interface RemoteDataSource {

    suspend fun getNews(): Result<NewsDTO, DataError.Remote>
}