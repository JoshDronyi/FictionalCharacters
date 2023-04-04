package com.example.datalayer.network.services

import com.example.datalayer.network.dtos.pokemondtos.pokemon.PokemonResponseDTO
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.PokemonInTypeResponse
import com.example.datalayer.network.dtos.pokemondtos.type.TypeResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET(TYPE_ENDPOINT)
    suspend fun getPokemonTypes(): TypeResponseDTO

    @GET(POKEMON_IN_TYPE_ENDPOINT)
    suspend fun getPokemonInType(@Path("type") type: String): PokemonInTypeResponse

    @GET(POKEMON_ENDPOINT)
    suspend fun getPokemon(@Path("pokemonID") pokemonID: Int): PokemonResponseDTO

    companion object {
        const val BASE_URL = "https://pokeapi.co/"
        const val TYPE_ENDPOINT = "api/v2/type"
        const val POKEMON_IN_TYPE_ENDPOINT = "api/v2/type/{type}"
        const val POKEMON_ENDPOINT = "api/v2/pokemon/{pokemonID}/"
    }
}
