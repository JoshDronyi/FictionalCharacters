package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import kotlinx.serialization.Serializable

@Serializable
data class Size(
    val height: Int? = null,
    val width: Int? = null
)