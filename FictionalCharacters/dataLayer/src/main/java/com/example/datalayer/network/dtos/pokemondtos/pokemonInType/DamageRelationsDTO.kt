package com.example.datalayer.network.dtos.pokemondtos.pokemonInType

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DamageRelationsDTO(
    @SerialName("double_damage_from")
    val doubleDamageFrom: List<DetailsDTO>,
    @SerialName("double_damage_to")
    val doubleDamageTo: List<DetailsDTO>,
    @SerialName("half_damage_from")
    val halfDamageFrom: List<DetailsDTO>,
    @SerialName("half_damage_to")
    val halfDamageTo: List<DetailsDTO>,
    @SerialName("no_damage_from")
    val noDamageFrom: List<DetailsDTO> = emptyList(),
    @SerialName("no_damage_to")
    val noDamageTo: List<DetailsDTO> = emptyList(),
)
