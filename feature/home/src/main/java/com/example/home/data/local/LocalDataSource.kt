package com.example.home.data.local

import com.example.core.data.local.db.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
interface LocalDataSource {
    suspend fun addNews(news: List<NewsEntity>)
    fun getLatestNews(): Flow<List<NewsEntity>>
}