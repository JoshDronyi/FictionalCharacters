package com.example.datalayer.repos

import com.example.datalayer.local.daos.SuperHeroDao
import com.example.datalayer.local.entities.superhero.SuperHero
import com.example.datalayer.mappers.superheroMappers.SuperHeroMapper
import com.example.datalayer.network.services.SuperHeroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SuperHeroRepo(
    private val superHeroDao: SuperHeroDao,
    private val superHeroService: SuperHeroService,
    private val superHeroMapper: SuperHeroMapper,
) {
    suspend fun getHero(hero: String = "Hulk"): List<SuperHero> = withContext(Dispatchers.IO) {
        val heroes = superHeroService.searchSuperheroByName(hero).results
        heroes.map {
            superHeroMapper(it)
        }
    }
}
