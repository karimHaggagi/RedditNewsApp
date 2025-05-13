package com.example.redditnews.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.redditnews.data.local.entity.NewsEntity

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}