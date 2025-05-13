package com.example.redditnews.di


import com.example.redditnews.data.network.RemoteDataSource
import com.example.redditnews.data.network.RetrofitRemoteDataSource
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
}