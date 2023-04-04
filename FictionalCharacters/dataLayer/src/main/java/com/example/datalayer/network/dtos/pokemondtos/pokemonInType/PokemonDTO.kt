package com.example.datalayer.network.dtos.pokemondtos.pokemonInType

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDTO(
    val pokemon: DetailsDTO,
    val slot: Int,
)
