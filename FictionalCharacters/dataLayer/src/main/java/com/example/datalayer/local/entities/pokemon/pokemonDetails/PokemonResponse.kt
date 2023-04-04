package com.example.datalayer.local.entities.pokemon.pokemonDetails

import androidx.room.Embedded
import androidx.room.Entity
import com.example.datalayer.local.entities.pokemon.pokemonInType.Details
import com.example.datalayer.local.entities.pokemon.pokemonInType.Pokemon

@Entity
data class PokemonResponse(
    val abilities: List<Ability> = emptyList(),
    val baseExperience: Int = 0,
    val forms: List<Details> = emptyList(),
    val height: Int = 0,
    val id: Int = 0,
    val isDefault: Boolean = false,
    val locationAreaEncounters: String = "",
    val moves: List<Move> = emptyList(),
    val name: String = "",
    val order: Int = 0,
    val pastTypes: List<PastType> = emptyList(),
    val species: Details = Details(),
    val sprites: Sprites = Sprites(),
    val stats: List<Stats> = emptyList(),
    val types: List<PokemonType> = emptyList(),
    val weight: Int = 0,
)

data class AbilityRelation(
    @Embedded() val pokemon: Pokemon
)
