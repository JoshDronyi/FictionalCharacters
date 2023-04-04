package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.VersionGroupDetail
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.VersionGroupDetailDTO

class VGDMapper(
    private val detailsMapper: DetailsMapper,
) : Mapper<VersionGroupDetailDTO, VersionGroupDetail> {
    override suspend fun invoke(entity: VersionGroupDetailDTO): VersionGroupDetail = with(entity) {
        return VersionGroupDetail(
            levelLearnedAt,
            detailsMapper(moveLearnMethod),
            detailsMapper(versionGroup),
        )
    }
}
