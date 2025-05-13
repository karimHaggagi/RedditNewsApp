package com.example.redditnews.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.redditnews.presentation.Screens
import com.example.redditnews.presentation.home.NewsUiModel
import com.example.redditnews.utils.CustomNavType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.reflect.typeOf

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@HiltViewModel
class DetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val newsItem = savedStateHandle.toRoute<Screens.Details>(
        typeMap = mapOf(
            typeOf<NewsUiModel>() to CustomNavType.newsModelType,
        )
    )

    private val _newsItemFlow = MutableStateFlow(newsItem.newsModel)
    val newsItemFlow = _newsItemFlow.asStateFlow()
}