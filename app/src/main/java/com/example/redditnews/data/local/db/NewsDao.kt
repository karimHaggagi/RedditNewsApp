package com.example.redditnews.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.redditnews.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)

    @Query("SELECT * FROM news")
    fun getLatestNews(): Flow<List<NewsEntity>>

}