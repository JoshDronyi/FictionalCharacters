package com.example.datalayer.network.services

import com.example.datalayer.BuildConfig
import com.example.datalayer.network.dtos.superherodtos.SuperHeroResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET(SEARCH_ENDPOINT)
    suspend fun searchSuperheroByName(
        @Path("name") name: String,
        @Path("token") key: String = BuildConfig.ApikeySuperhero,
    ): SuperHeroResponseDTO

    companion object {
        const val BASE_URL = "https://superheroapi.com/api/"
        private const val SEARCH_ENDPOINT = "/{token}/search/{name}"
    }
}
