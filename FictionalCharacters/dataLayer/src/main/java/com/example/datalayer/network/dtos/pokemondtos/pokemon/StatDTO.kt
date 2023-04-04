package com.example.datalayer.network.dtos.pokemondtos.pokemon

import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatDTO(
    @SerialName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: DetailsDTO,
)
