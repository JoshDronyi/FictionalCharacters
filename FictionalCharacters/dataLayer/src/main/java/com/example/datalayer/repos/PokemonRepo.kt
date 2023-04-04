package com.example.datalayer.repos

import com.example.datalayer.local.daos.PokemonDao
import com.example.datalayer.mappers.pokemonMappers.PokemonResponseMapper
import com.example.datalayer.mappers.pokemonMappers.TypeMapper
import com.example.datalayer.network.services.PokemonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepo(
    private val pokemonDAO: PokemonDao,
    private val pokemonService: PokemonService,
    private val typeMapper: TypeMapper,
    val pokemonMapper: PokemonResponseMapper,
) {
    suspend fun getTypes() = withContext(Dispatchers.IO) {
        pokemonService.getPokemonTypes().results.map {
            typeMapper(it)
        }
    }

    suspend fun getPokemonInType(type: String = "fire") = withContext(Dispatchers.IO) {
        pokemonService.getPokemonInType(type)
    }

    suspend fun getPokemon(id: Int = 135) = withContext(Dispatchers.IO) {
        pokemonMapper(pokemonService.getPokemon(id))
    }
}
