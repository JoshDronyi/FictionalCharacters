package com.example.datalayer.network.dtos.pokemondtos.type

import kotlinx.serialization.Serializable

@Serializable
data class TypeDTO(
    val name: String,
    val url: String,
)
