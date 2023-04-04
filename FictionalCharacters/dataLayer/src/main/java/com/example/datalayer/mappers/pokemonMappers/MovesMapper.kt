package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.Move
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.MoveDTO

class MovesMapper(
    private val detailsMapper: DetailsMapper = DetailsMapper(),
    private val vgdMapper: VGDMapper,
) : Mapper<MoveDTO, Move> {
    override suspend fun invoke(entity: MoveDTO): Move = with(entity) {
        return Move(
            move = detailsMapper(move),
            versionGroupDetails = versionGroupDetails.map { vgdMapper(it) },
        )
    }
}
