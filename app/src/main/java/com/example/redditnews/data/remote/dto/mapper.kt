package com.example.redditnews.data.remote.dto

import com.example.redditnews.data.local.entity.NewsEntity
import com.example.redditnews.domain.model.NewsDomainModel

/**
 * created by Karim Haggagi Hassan Elsayed on 5/12/25
 **/

fun NewsDTO.asNewsDomainModel(): List<NewsDomainModel> {
    return newsData?.children?.map { children ->
        NewsDomainModel(
            id = children.childrenData?.id ?: "",
            title = children.childrenData?.title ?: "",
            body = children.childrenData?.selftext ?: "",
            thumbnailUrl = children.childrenData?.media?.oembed?.thumbnail_url ?: "",
            thumbnailWidth = children.childrenData?.media?.oembed?.thumbnail_width ?: 0,
            thumbnailHeight = children.childrenData?.media?.oembed?.thumbnail_height ?: 0
        )
    } ?: emptyList()

}

fun NewsDTO.asNewsEntity(): List<NewsEntity> {
    return newsData?.children?.map { children ->
        NewsEntity(
            id = children.childrenData?.id ?: "",
            title = children.childrenData?.title ?: "",
            body = children.childrenData?.selftext ?: "",
            thumbnailUrl = children.childrenData?.media?.oembed?.thumbnail_url ?: "",
            thumbnailWidth = children.childrenData?.media?.oembed?.thumbnail_width ?: 0,
            thumbnailHeight = children.childrenData?.media?.oembed?.thumbnail_height ?: 0
        )
    } ?: emptyList()
}

fun NewsEntity.asNewsDomainModel(): NewsDomainModel {
    return NewsDomainModel(
        id = id,
        title = title,
        body = body,
        thumbnailUrl = thumbnailUrl,
        thumbnailWidth = thumbnailWidth,
        thumbnailHeight = thumbnailHeight
    )
}