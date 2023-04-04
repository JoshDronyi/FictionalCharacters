package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.PokemonType
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.PokemonTypeDTO

class PokemonTypeMapper(
    val detailsMapper: DetailsMapper = DetailsMapper(),
) : Mapper<PokemonTypeDTO, PokemonType> {
    override suspend fun invoke(entity: PokemonTypeDTO): PokemonType = with(entity) {
        return PokemonType(
            slot = slot,
            type = detailsMapper(type),
        )
    }
}
