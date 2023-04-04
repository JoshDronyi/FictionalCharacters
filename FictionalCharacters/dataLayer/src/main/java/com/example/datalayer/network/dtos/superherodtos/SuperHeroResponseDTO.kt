package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SuperHeroResponseDTO(
    val response: String = "",
    val results: List<SuperHeroDTO> = emptyList(),
    @SerialName("results-for")
    val resultsFor: String = "",
)
