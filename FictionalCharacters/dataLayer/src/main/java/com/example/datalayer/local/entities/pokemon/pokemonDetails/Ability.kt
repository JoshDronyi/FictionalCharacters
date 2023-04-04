package com.example.datalayer.local.entities.pokemon.pokemonDetails

import androidx.room.PrimaryKey
import com.example.datalayer.local.entities.pokemon.pokemonInType.Details

data class Ability(
    @PrimaryKey() val id: Int = 0,
    val pokemonID: Int = 0,
    val ability: Details,
    val isHidden: Boolean,
    val slot: Int,
)
