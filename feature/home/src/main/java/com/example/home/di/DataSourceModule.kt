package com.example.home.di


import com.example.home.data.local.RoomLocalDataSource
import com.example.home.data.remote.network.RetrofitRemoteDataSource
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
    fun provideRemoteDataSource(dataSource: RetrofitRemoteDataSource): com.example.home.data.remote.network.RemoteDataSource

    @Binds
    fun provideLocalDataSource(dataSource: RoomLocalDataSource): com.example.home.data.local.LocalDataSource
}