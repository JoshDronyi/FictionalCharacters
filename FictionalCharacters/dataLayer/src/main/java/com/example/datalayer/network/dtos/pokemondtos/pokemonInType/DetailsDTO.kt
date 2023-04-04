package com.example.datalayer.network.dtos.pokemondtos.pokemonInType

import kotlinx.serialization.Serializable

@Serializable
data class DetailsDTO(
    val name: String,
    val url: String,
)
