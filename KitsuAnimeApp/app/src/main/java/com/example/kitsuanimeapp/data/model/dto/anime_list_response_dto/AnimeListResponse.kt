package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import com.example.kitsuanimeapp.data.model.dto.categoryResponseDTO.Meta
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeListResponse(
    @SerialName("data")
    val animeList: List<Data>,
    @SerialName("links")
    val links: Pagination,
    val meta: MetaX
)