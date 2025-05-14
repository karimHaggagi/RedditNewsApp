package com.example.home.domain.repo

import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.model.NewsDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
interface NewsRepo {
    suspend fun getNews(): Flow<Result<List<NewsDomainModel>, DataError>>
}