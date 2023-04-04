package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val first: String,
    val last: String,
    val next: String
)