package com.example.redditnews.presentation.home

import com.example.redditnews.core.presentation.UiText
import com.example.redditnews.domain.model.NewsDomainModel

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
data class HomeUiState(
    val isLoading: Boolean = true,
    val news: List<NewsUiModel> = emptyList(),
    val error: UiText? = null
)

data class NewsUiModel(
    val id: String,
    val title: String,
    val body: String,
    val thumbnailUrl: String,
    val thumbnailWidth: Int,
    val thumbnailHeight: Int
) {
    val hasImage: Boolean get() = thumbnailUrl != ""
}

fun NewsDomainModel.asNewsUiModel() =
    NewsUiModel(
        id = id,
        title = title,
        body = body,
        thumbnailUrl = thumbnailUrl,
        thumbnailWidth = thumbnailWidth,
        thumbnailHeight = thumbnailHeight
    )