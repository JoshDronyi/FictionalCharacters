package com.example.datalayer.network.dtos.pokemondtos.pokemon

import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class AbilityDTO(
    val ability: DetailsDTO,
    @SerialName("is_hidden")
    val isHidden: Boolean,
    val slot: Int,
)
