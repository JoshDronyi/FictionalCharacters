package com.example.datalayer.network.dtos.pokemondtos.type

import kotlinx.serialization.Serializable

@Serializable
data class TypeResponseDTO(
    val count: Int,
    val next: Int? = null,
    val previous: Int? = null,
    val results: List<TypeDTO>,
)
