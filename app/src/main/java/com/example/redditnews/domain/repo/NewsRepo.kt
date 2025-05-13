package com.example.redditnews.domain.repo

import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.domain.model.NewsDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
interface NewsRepo {
    suspend fun getNews(): Flow<Result<List<NewsDomainModel>, DataError>>
}