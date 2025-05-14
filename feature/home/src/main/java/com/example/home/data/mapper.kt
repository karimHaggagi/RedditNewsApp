package com.example.home.data

import com.example.core.data.local.db.entity.NewsEntity
import com.example.home.data.remote.dto.NewsDTO
import com.example.core.domain.model.NewsDomainModel

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