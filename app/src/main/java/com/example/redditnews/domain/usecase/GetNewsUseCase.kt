package com.example.redditnews.domain.usecase

import com.example.redditnews.core.domain.DataError
import com.example.redditnews.core.domain.Result
import com.example.redditnews.domain.model.NewsDomainModel
import com.example.redditnews.domain.repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
class GetNewsUseCase @Inject constructor(private val newsRepo: NewsRepo) {

    suspend operator fun invoke(): Flow<Result<List<NewsDomainModel>, DataError>> {
        return newsRepo.getNews()
    }
}