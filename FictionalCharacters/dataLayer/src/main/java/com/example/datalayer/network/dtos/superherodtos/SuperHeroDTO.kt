package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.Serializable

@Serializable
data class SuperHeroDTO(
    val id: String,
    val name: String,
    val appearance: AppearanceDTO,
    val biography: BiographyDTO,
    val connections: ConnectionsDTO,
    val image: ImageDTO,
    val powerstats: PowerstatsDTO,
    val work: WorkDTO,
)
