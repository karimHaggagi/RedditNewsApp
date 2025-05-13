package com.example.redditnews.data.local.db

import com.example.redditnews.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
interface LocalDataSource {
    suspend fun addNews(news: List<NewsEntity>)
    fun getLatestNews(): Flow<List<NewsEntity>>
}