package com.example.datalayer.local.entities.superhero

data class Biography(
    val aliases: List<String> = emptyList(),
    val alignment: String = "",
    val alterEgos: String = "",
    val firstAppearance: String = "",
    val fullName: String = "",
    val placeOfBirth: String = "",
    val publisher: String = "",
)
