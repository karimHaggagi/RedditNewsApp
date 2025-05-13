package com.example.redditnews.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redditnews.core.domain.onError
import com.example.redditnews.core.domain.onSuccess
import com.example.redditnews.core.presentation.toUiText
import com.example.redditnews.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/
@HiltViewModel
class HomeViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState
        .onStart {
            getNews()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            HomeUiState()
        )

    fun getNews() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getNewsUseCase()
                .collectLatest { newsResult ->
                    newsResult.onSuccess { response ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                news = response.map { item -> item.asNewsUiModel() })
                        }
                    }
                        .onError { error ->
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                    error = error.toUiText()
                                )
                            }
                        }
                }
        }
    }

    fun hideErrorDialog() {
        _uiState.update { it.copy(error = null) }
    }

}