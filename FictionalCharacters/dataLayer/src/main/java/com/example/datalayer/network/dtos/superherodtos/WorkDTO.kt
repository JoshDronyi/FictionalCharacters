package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.Serializable

@Serializable
data class WorkDTO(
    val base: String = "",
    val occupation: String = "",
)
