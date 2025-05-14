package com.example.core.presentation.model

import kotlinx.serialization.Serializable

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Serializable
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