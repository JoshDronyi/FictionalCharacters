package com.example.datalayer.network.dtos.pokemondtos.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IconsDTO(
    @SerialName("front_default")
    val frontDefault: String = "",
    @SerialName("front_female")
    val frontFemale: String? = "",
)
