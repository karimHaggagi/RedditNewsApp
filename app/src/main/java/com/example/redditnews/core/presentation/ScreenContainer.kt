package com.example.redditnews.core.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.redditnews.core.presentation.CircularLoading
import com.example.redditnews.core.presentation.ErrorDialog

@Composable
fun ScreenContainer(
    modifier: Modifier = Modifier,
    screen: @Composable (() -> Unit),
    isLoading: Boolean,
    errorDialogText: UiText? = null,
    onDialogButtonClick: () -> Unit = {}
) {
    Box(modifier = modifier) {
        screen()
        CircularLoading(isLoading = isLoading)
        AnimatedVisibility(visible = errorDialogText != null) {
            errorDialogText?.let {
                ErrorDialog(errorMessage = it) {
                    onDialogButtonClick()
                }
            }
        }
    }
}
