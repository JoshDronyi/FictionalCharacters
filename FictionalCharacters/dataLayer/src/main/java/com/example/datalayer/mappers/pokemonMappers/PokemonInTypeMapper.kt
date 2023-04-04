package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonInType.DetailRelation
import com.example.datalayer.local.entities.pokemon.pokemonInType.PokemonInType
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.PokemonInTypeResponse

class PokemonInTypeMapper(
    val detailsMapper: DetailsMapper = DetailsMapper(),
    val damageRelationsMapper: DamageRelationsMapper = DamageRelationsMapper(detailsMapper),
    val pokemonMapper: PokemonMapper = PokemonMapper(detailsMapper),
) : Mapper<PokemonInTypeResponse, PokemonInType> {
    override suspend fun invoke(entity: PokemonInTypeResponse): PokemonInType = with(entity) {
        return PokemonInType(
            damageRelations = damageRelationsMapper(damageRelations),
            moves = DetailRelation(
                moves = moves.map { detailsMapper(it) },
                pokemonInTypeID = this.id,
            ),
            moveDamageClass = detailsMapper(moveDamageClass),
            pastDamageRelations = DetailRelation(
                pokemonInTypeID = this.id,
                moves = pastDamageRelations.map { detailsMapper(it) },
            ),
            name = name,
            pokemon = pokemon.map { pokemonMapper(it) },
        )
    }
}
