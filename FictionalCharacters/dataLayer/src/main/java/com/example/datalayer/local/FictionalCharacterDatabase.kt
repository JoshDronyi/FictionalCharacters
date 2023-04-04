package com.example.datalayer.local

import androidx.room.Database
import com.example.datalayer.local.entities.pokemon.type.Type
import com.example.datalayer.local.entities.superhero.SuperHero
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.PokemonInTypeResponse

@Database(entities = [SuperHero::class, Type::class, PokemonInTypeResponse::class], exportSchema = true, version = 1)
class FictionalCharacterDatabase
