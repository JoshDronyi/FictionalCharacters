package com.example.datalayer.local.entities.pokemon.pokemonInType

import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation

enum class DamageType(val type: String) {
    DoubleDamageFrom("DoubleDamageFrom"),
    DoubleDamageTo("DoubleDamageTo"),
    HalfDamageFrom("HalfDamageFrom"),
    HalfDamageTo("HalfDamageTo"),
    NoDamageFrom("NoDamageFrom"),
    NoDamageTo("NoDamageTo"),
}

data class DamageTypeText(
    @PrimaryKey(autoGenerate = true) val dttID: Int,
    val type: String,
)

data class DamageValues(
    @PrimaryKey(autoGenerate = true)
    val damageId: Int = 0,
    @Embedded() val damageType: DamageTypeText,
    @Relation(
        parentColumn = "dttID",
        entityColumn = "dttID",
    )
    val details: List<Details>,
)
