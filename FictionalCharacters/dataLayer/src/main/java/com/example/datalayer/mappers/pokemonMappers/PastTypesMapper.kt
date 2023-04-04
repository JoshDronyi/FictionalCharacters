package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.PastType
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.PastTypeDTO

class PastTypesMapper(
    val pokemonTypeMapper: PokemonTypeMapper,
) : Mapper<PastTypeDTO, PastType> {
    override suspend fun invoke(entity: PastTypeDTO): PastType = with(entity) {
        val jawn = types.map { pokemonTypeMapper(it) }
        return PastType(types = jawn)
    }
}
