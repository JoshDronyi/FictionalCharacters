package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeListAttributes(
    @SerialName("ageRating")
    val ageRating: String,
    val ageRatingGuide: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage? = null,
    val coverImageTopOffset: Int,
    val description: String,
    val endDate: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val nsfw: Boolean,
    val posterImage: PosterImage,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val totalLength: Int,
)