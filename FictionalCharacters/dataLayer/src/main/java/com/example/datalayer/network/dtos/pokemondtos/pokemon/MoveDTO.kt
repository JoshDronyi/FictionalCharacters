package com.example.datalayer.network.dtos.pokemondtos.pokemon

import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveDTO(
    val move: DetailsDTO,
    @SerialName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailDTO> = emptyList(),
)
