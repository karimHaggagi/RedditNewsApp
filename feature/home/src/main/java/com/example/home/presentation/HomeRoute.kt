package com.example.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.presentation.ScreenContainer
import com.example.core.presentation.model.NewsUiModel
import com.example.home.presentation.component.NewsListItem

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (NewsUiModel) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenContainer(
        modifier = modifier,
        isLoading = state.isLoading,
        errorDialogText = state.error,
        onDialogButtonClick = viewModel::hideErrorDialog,
        screen = {
            HomeScreen(state = state, onItemClick = onItemClick)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onItemClick: (NewsUiModel) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Kotlin News",
                    fontWeight = FontWeight.Bold
                )
            })
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            itemsIndexed(state.news, key = {position,item -> item.id }) {position,item ->
                NewsListItem(
                    modifier = Modifier.testTag("news_item_${position}") // for testing
                    , newsItem = item, onClick = { onItemClick(item) })
            }
        }
    }
}