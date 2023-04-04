package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppearanceDTO(
    @SerialName("eye-color")
    val eyeColor: String = "",
    val gender: String = "",
    @SerialName("hair-color")
    val hairColor: String = "",
    val height: List<String> = emptyList(),
    val race: String = "",
    val weight: List<String> = emptyList(),
)
