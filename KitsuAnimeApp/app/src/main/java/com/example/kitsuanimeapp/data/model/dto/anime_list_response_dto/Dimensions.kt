package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import kotlinx.serialization.Serializable

@Serializable
data class Dimensions(
    val large: Size,
    val medium: Size? = null,
    val small: Size,
    val tiny: Size
)