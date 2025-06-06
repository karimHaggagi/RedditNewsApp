package com.example.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.presentation.model.NewsUiModel

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Composable
fun DetailsRoute(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {
    val state by viewModel.newsItemFlow.collectAsStateWithLifecycle()
    DetailsScreen(modifier = modifier, newsItem = state, onNavigateUp = onNavigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(
    modifier: Modifier = Modifier,
    newsItem: NewsUiModel,
    onNavigateUp: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.testTag("details_top_bar"),
                title = {
                    BasicText(
                        text = newsItem.title,
                        maxLines = 2,
                        autoSize = TextAutoSize.StepBased()
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.testTag("navigation_back"),
                        onClick = onNavigateUp
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                })
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            if (newsItem.hasImage) {
                com.example.core.presentation.NewsImage(
                    imageUrl = newsItem.thumbnailUrl,
                    imageWidth = newsItem.thumbnailWidth,
                    imageHeight = newsItem.thumbnailHeight
                )
            }
            Text(text = newsItem.body, color = Color.Black, modifier = Modifier.padding(16.dp))
        }
    }

}

@Preview
@Composable
private fun DetailsScreenPreview() {
    DetailsScreen(
        newsItem = NewsUiModel(
            id = "1",
            title = "Title",
            thumbnailUrl = "",
            thumbnailWidth = 0,
            thumbnailHeight = 0,
            body = "Body"
        )
    )
}