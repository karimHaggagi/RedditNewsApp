package com.example.core.di

import android.content.Context
import androidx.room.Room
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
    fun provideDatabase(@ApplicationContext applicationContext: Context): com.example.core.data.local.db.NewsDatabase {

        return Room.databaseBuilder(
            applicationContext,
            com.example.core.data.local.db.NewsDatabase::class.java, "Weather"
        ).fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: com.example.core.data.local.db.NewsDatabase) = database.newsDao()
}