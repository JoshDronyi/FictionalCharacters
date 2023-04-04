package com.example.datalayer.network.dtos.pokemondtos.pokemon

import kotlinx.serialization.Serializable

@Serializable
data class PastTypeDTO(
    val types: List<PokemonTypeDTO> = emptyList(),
)
