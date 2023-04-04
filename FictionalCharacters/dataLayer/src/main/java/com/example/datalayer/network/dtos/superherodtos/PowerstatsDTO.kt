package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.Serializable

@Serializable
data class PowerstatsDTO(
    val combat: String,
    val durability: String,
    val intelligence: String,
    val power: String,
    val speed: String,
    val strength: String,
)
