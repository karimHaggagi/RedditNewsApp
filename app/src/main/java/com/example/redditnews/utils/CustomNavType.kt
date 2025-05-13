package com.example.redditnews.utils

import android.net.Uri
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.redditnews.presentation.home.NewsUiModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
object CustomNavType {

    val newsModelType = object : NavType<NewsUiModel>(isNullableAllowed = false) {
        override fun put(bundle: SavedState, key: String, value: NewsUiModel) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun get(bundle: SavedState, key: String): NewsUiModel? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): NewsUiModel {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: NewsUiModel): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}