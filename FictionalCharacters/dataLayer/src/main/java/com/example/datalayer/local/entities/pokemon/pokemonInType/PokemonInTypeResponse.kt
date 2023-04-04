package com.example.datalayer.local.entities.pokemon.pokemonInType

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity()
data class PokemonInType(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded() val damageRelations: DamageRelations,
    @Embedded("moveDamage") val moveDamageClass: Details,
    val moves: DetailRelation,
    val name: String,
    val pastDamageRelations: DetailRelation,
    val pokemon: List<Pokemon>,
)

data class DetailRelation(
    val mrID: Int = 0,
    val pokemonInTypeID: Int = 0,
    @Relation(
        parentColumn = "id",
        entityColumn = "dttID",
    )
    val moves: List<Details> = emptyList(),
)
