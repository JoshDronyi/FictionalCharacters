package com.example.datalayer.network.dtos.superherodtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConnectionsDTO(
    @SerialName("group-affiliation")
    val groupAffiliation: String = "",
    val relatives: String = "",
)
