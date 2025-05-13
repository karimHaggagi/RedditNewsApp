package com.example.redditnews.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * created by Karim Haggagi Hassan Elsayed on 5/13/25
 **/
@Entity(tableName = "news")
data class NewsEntity(
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("thumbnail")
    val thumbnailUrl: String,
    @SerializedName("thumbnail_width")
    val thumbnailWidth: Int,
    @SerializedName("thumbnail_height")
    val thumbnailHeight: Int,
    @PrimaryKey
    val id: String
)
