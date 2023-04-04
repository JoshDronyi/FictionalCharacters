package com.example.datalayer.network.dtos.pokemondtos.pokemon

import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeDTO(
    val slot: Int,
    val type: DetailsDTO,
)
