package com.example.redditnews.di

import android.content.Context
import androidx.room.Room
import com.example.redditnews.data.local.db.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Module
@InstallIn(SingletonComponent::class)
object AppLocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): NewsDatabase {

        return Room.databaseBuilder(
            applicationContext,
            NewsDatabase::class.java, "Weather"
        ).fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: NewsDatabase) = database.newsDao()
}