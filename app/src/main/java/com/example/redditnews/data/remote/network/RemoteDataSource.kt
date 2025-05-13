package com.example.redditnews.data.remote.network

import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.data.remote.dto.NewsDTO

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
interface RemoteDataSource {

    suspend fun getNews(): Result<NewsDTO, DataError.Remote>
}