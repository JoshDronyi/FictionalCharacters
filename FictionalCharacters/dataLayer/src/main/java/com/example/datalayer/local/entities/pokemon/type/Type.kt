package com.example.datalayer.local.entities.pokemon.type

import androidx.room.Entity

@Entity
data class Type(
    val name: String = "",
    val url: String = "",
)
