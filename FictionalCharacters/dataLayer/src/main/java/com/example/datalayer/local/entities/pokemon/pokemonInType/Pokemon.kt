package com.example.datalayer.local.entities.pokemon.pokemonInType

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class Pokemon(
    val id: Int = 0,
    @Embedded("pokemon_") val pokemon: Details,
    val slot: Int,
)
