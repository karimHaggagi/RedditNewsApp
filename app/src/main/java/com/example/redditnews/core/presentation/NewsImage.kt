package com.example.redditnews.core.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.example.redditnews.R

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Composable
fun NewsImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    imageWidth: Int = 0,
    imageHeight: Int = 0
) {
    val painter = rememberAsyncImagePainter(imageUrl)
    val state by painter.state.collectAsState()

    val aspectRatio =
        remember { if (imageWidth > 0 && imageHeight > 0) imageWidth.toFloat() / imageHeight else 16f / 9f }

    Box(modifier = modifier.fillMaxWidth()) {
        when (state) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is AsyncImagePainter.State.Success -> {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(aspectRatio),
                    contentScale = ContentScale.Crop,
                    painter = painter,
                    contentDescription = null
                )
            }

            is AsyncImagePainter.State.Error -> {
                // Show some error UI.
                Log.d(
                    "TAG",
                    "onCreate: ${(state as AsyncImagePainter.State.Error).result.throwable}"
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(aspectRatio),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.broken_image),
                    contentDescription = null
                )
            }
        }
    }
}