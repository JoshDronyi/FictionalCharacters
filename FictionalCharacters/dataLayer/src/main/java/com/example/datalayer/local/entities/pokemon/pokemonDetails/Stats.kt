package com.example.datalayer.local.entities.pokemon.pokemonDetails

import com.example.datalayer.local.entities.pokemon.pokemonInType.Details

data class Stats(
    val baseStat: Int,
    val effort: Int,
    val stat: Details,
)
