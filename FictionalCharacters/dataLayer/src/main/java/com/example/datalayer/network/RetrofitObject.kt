package com.example.datalayer.network

import com.example.datalayer.network.services.PokemonService
import com.example.datalayer.network.services.SuperHeroService
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object RetrofitObject {
    private const val TIMEOUT_DURATION = 15L
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .callTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .build()

    private val retrofitBuilder = Retrofit.Builder()
        .client(client)

    fun getSuperHeroService(): SuperHeroService = retrofitBuilder
        .baseUrl(SuperHeroService.BASE_URL)
        .build().create()

    fun getPokemonService(): PokemonService = retrofitBuilder
        .baseUrl(PokemonService.BASE_URL)
        .build().create()
}
