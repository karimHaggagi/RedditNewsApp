package com.example.redditnews.presentation

import com.example.redditnews.domain.model.NewsDomainModel
import kotlinx.serialization.Serializable

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
sealed class Screens {
    @Serializable
    data object Home : Screens()

    @Serializable
    data class Details(val newsDomainModel: NewsDomainModel):Screens()
}