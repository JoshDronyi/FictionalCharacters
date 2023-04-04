package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonInType.Details
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO

class DetailsMapper : Mapper<DetailsDTO, Details> {
    override suspend fun invoke(entity: DetailsDTO): Details = with(entity) {
        return Details(
            name = name,
            url = url,
        )
    }
}
