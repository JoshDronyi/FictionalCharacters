package com.example.datalayer.local.entities.pokemon.pokemonDetails

import com.example.datalayer.local.entities.pokemon.pokemonInType.Details

data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val moveLearnMethod: Details,
    val versionGroup: Details,
)
