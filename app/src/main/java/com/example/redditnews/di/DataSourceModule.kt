package com.example.redditnews.di


import com.example.redditnews.data.local.db.LocalDataSource
import com.example.redditnews.data.local.db.RoomLocalDataSource
import com.example.redditnews.data.remote.network.RemoteDataSource
import com.example.redditnews.data.remote.network.RetrofitRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun provideRemoteDataSource(dataSource: RetrofitRemoteDataSource): RemoteDataSource

    @Binds
    fun provideLocalDataSource(dataSource: RoomLocalDataSource): LocalDataSource
}