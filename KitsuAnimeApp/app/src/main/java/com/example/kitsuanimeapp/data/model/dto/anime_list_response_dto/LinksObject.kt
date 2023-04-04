package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import com.example.kitsuanimeapp.data.model.dto.categoryResponseDTO.Links
import kotlinx.serialization.Serializable

@Serializable
data class LinksObject(
    val links: Links
)