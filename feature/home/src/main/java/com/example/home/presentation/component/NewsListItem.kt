package com.example.home.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.model.NewsUiModel

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/

@Composable
fun NewsListItem(modifier: Modifier = Modifier, newsItem: NewsUiModel, onClick: () -> Unit ={}) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        onClick = onClick) {
        Text(
            text = newsItem.title,
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(16.dp)
        )
        if (newsItem.hasImage) {
            com.example.core.presentation.NewsImage(
                imageUrl = newsItem.thumbnailUrl,
                imageWidth = newsItem.thumbnailWidth,
                imageHeight = newsItem.thumbnailHeight
            )
        }
    }
}

@Preview
@Composable
private fun NewsListItemPreview() {
    NewsListItem(
        newsItem =
            NewsUiModel(
                title = "News Title",
                body = "News Body",
                thumbnailUrl = "https://via.placeholder.com/150",
                thumbnailWidth = 150,
                thumbnailHeight = 150,
                id = ""
            )
    )
}