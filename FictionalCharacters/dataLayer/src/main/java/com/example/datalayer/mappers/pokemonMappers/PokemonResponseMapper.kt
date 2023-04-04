package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.PokemonResponse
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.PokemonResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async

class PokemonResponseMapper(
    private val abilityMapper: AbilityMapper,
    private val formsMapper: DetailsMapper,
    private val movesMapper: MovesMapper,
    private val pastTypesMapper: PastTypesMapper,
    private val speciesMapper: DetailsMapper,
    private val spriteMapper: SpriteMapper,
    private val statMapper: StatMapper,
    private val pokemonTypeMapper: PokemonTypeMapper,
) : Mapper<PokemonResponseDTO, PokemonResponse> {

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override suspend fun invoke(entity: PokemonResponseDTO): PokemonResponse = with(entity) {
        val abilityList = scope.async { abilities.map { abilityMapper(it) } }
        val formList = scope.async { forms.map { formsMapper(it) } }
        val movesList = scope.async { moves.map { movesMapper(it) } }
        val pastTypesList = scope.async { pastTypes.map { pastTypesMapper(it) } }
        val statList = scope.async { stats.map { statMapper(it) } }
        val pokemonTypeList = scope.async { types.map { pokemonTypeMapper(it) } }

        return PokemonResponse(
            abilities = abilityList.await(),
            baseExperience = baseExperience,
            forms = formList.await(),
            height = height,
            id = id,
            isDefault = isDefault,
            locationAreaEncounters = locationAreaEncounters,
            moves = movesList.await(),
            name = name,
            order = order,
            pastTypes = pastTypesList.await(),
            species = speciesMapper(species),
            sprites = spriteMapper(sprites),
            stats = statList.await(),
            types = pokemonTypeList.await(),
            weight = weight,
        )
    }
}
