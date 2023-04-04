package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonInType.Pokemon
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.PokemonDTO

class PokemonMapper(
    val detailsMapper: DetailsMapper,
) : Mapper<PokemonDTO, Pokemon> {
    override suspend fun invoke(entity: PokemonDTO): Pokemon = with(entity) {
        return Pokemon(
            slot = slot,
            pokemon = detailsMapper(pokemon),
        )
    }
}
