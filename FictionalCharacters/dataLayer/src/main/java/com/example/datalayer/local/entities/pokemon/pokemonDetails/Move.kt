package com.example.datalayer.local.entities.pokemon.pokemonDetails

import com.example.datalayer.local.entities.pokemon.pokemonInType.Details

data class Move(
    val move: Details,
    val versionGroupDetails: List<VersionGroupDetail> = emptyList(),
)
