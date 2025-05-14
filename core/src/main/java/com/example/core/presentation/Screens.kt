package com.example.core.presentation

import com.example.core.presentation.model.NewsUiModel
import kotlinx.serialization.Serializable

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Serializable
sealed class Screens {
    @Serializable
    data object Home : Screens()

    @Serializable
    data class Details(val newsModel: NewsUiModel): Screens()
}