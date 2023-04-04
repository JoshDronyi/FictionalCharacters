package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import kotlinx.serialization.Serializable

@Serializable
data class PosterImage(
    val large: String,
    val meta: MetaX
)