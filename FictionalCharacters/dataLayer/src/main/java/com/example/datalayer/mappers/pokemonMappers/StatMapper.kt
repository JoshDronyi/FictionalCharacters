package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.Stats
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.StatDTO

class StatMapper(
    val detailsMapper: DetailsMapper = DetailsMapper(),
) : Mapper<StatDTO, Stats> {
    override suspend fun invoke(entity: StatDTO): Stats = with(entity) {
        return Stats(
            baseStat = baseStat,
            effort = effort,
            stat = detailsMapper(stat),
        )
    }
}
