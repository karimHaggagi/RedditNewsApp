package com.example.redditnews.data.remote.network

import com.example.redditnews.data.remote.dto.NewsDTO
import retrofit2.Response
import retrofit2.http.GET

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
interface ApiService {

    @GET("r/kotlin/.json")
    suspend fun getNews():Response<NewsDTO>
}