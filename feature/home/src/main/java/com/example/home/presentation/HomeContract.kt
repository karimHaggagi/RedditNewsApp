package com.example.home.presentation

import com.example.core.domain.model.NewsDomainModel
import com.example.core.presentation.model.NewsUiModel


/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
data class HomeUiState(
    val isLoading: Boolean = true,
    val news: List<NewsUiModel> = emptyList(),
    val error: com.example.core.presentation.UiText? = null
)


fun NewsDomainModel.asNewsUiModel() =
    NewsUiModel(
        id = id,
        title = title,
        body = body,
        thumbnailUrl = thumbnailUrl,
        thumbnailWidth = thumbnailWidth,
        thumbnailHeight = thumbnailHeight
    )