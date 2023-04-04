package com.example.datalayer.network.dtos.pokemondtos.pokemonInType

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInTypeResponse(
    @SerialName("damage_relations")
    val damageRelations: DamageRelationsDTO,
    val id: Int,
    @SerialName("move_damage_class")
    val moveDamageClass: DetailsDTO,
    val moves: List<DetailsDTO>,
    val name: String,
    @SerialName("past_damage_relations")
    val pastDamageRelations: List<DetailsDTO>,
    val pokemon: List<PokemonDTO>,
)
