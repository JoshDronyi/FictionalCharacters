package com.example.datalayer.network.dtos.pokemondtos.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtherDTO(
    @SerialName("official-artwork")
    val officialArtwork: IconsDTO,
)
