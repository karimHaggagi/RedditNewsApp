package com.example.redditnews.domain.model

import kotlinx.serialization.Serializable

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
@Serializable
data class NewsDomainModel(
    val id: String,
    val title: String,
    val body: String,
    val thumbnailUrl: String,
    val thumbnailWidth: Int,
    val thumbnailHeight: Int,
)
