package com.example.home.di


import com.example.home.data.repository.NewsRepoImpl
import com.example.home.domain.repo.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun provideNewsRep(newsRepoImpl: NewsRepoImpl): NewsRepo

}