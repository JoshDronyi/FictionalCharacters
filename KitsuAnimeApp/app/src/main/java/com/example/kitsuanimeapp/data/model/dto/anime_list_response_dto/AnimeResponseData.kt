package com.example.kitsuanimeapp.data.model.dto.AnimeListResponseDto

import com.example.kitsuanimeapp.data.model.dto.categoryResponseDTO.Attributes
import com.example.kitsuanimeapp.data.model.dto.categoryResponseDTO.Links
import com.example.kitsuanimeapp.data.model.dto.categoryResponseDTO.Relationships
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val attributes: AnimeListAttributes,
    val id: String,
    val links: Links,
    val relationships: AnimeListRelationships,
    val type: String
)