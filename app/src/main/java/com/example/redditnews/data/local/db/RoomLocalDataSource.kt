package com.example.redditnews.data.local.db

import com.example.redditnews.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
class RoomLocalDataSource @Inject constructor(private val newsDao: NewsDao) : LocalDataSource {
    override suspend fun addNews(news: List<NewsEntity>) {
       newsDao.insertNews(news)
    }

    override fun getLatestNews(): Flow<List<NewsEntity>> {
        return newsDao.getLatestNews()
    }
}