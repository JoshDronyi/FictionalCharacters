package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.Ability
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.AbilityDTO

class AbilityMapper(
    private val detailsMapper: DetailsMapper = DetailsMapper(),
) : Mapper<AbilityDTO, Ability> {
    override suspend fun invoke(entity: AbilityDTO): Ability = with(entity) {
        return Ability(
            ability = detailsMapper(ability),
            isHidden = isHidden,
            slot = slot,
        )
    }
}
