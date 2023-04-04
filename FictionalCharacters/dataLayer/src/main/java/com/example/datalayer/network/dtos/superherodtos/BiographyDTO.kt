package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiographyDTO(
    val aliases: List<String> = emptyList(),
    val alignment: String = "",
    @SerialName("alter-egos")
    val alterEgos: String = "",
    @SerialName("first-appearance")
    val firstAppearance: String = "",
    @SerialName("full-name")
    val fullName: String = "",
    @SerialName("place-of-birth")
    val placeOfBirth: String = "",
    val publisher: String = "",
)
