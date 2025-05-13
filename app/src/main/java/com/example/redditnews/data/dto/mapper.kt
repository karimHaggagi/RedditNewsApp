package com.example.redditnews.data.dto

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