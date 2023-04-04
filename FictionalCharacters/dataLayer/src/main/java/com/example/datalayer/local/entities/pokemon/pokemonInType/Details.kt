package com.example.datalayer.local.entities.pokemon.pokemonInType

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Details(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dttID: Int = 0,
    val name: String = "",
    val url: String = "",
)
