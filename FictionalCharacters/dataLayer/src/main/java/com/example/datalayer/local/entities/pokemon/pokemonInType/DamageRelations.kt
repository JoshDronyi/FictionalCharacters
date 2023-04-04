package com.example.datalayer.local.entities.pokemon.pokemonInType

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DamageRelations(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val damageMap: Map<DamageType, DamageValues>,
)
