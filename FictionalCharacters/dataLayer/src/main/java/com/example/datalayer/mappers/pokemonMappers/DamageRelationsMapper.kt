package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonInType.DamageRelations
import com.example.datalayer.local.entities.pokemon.pokemonInType.DamageType
import com.example.datalayer.local.entities.pokemon.pokemonInType.DamageTypeText
import com.example.datalayer.local.entities.pokemon.pokemonInType.DamageValues
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DamageRelationsDTO
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO

class DamageRelationsMapper(
    private val detailsMapper: DetailsMapper,
) : Mapper<DamageRelationsDTO, DamageRelations> {
    override suspend fun invoke(entity: DamageRelationsDTO): DamageRelations = with(entity) {
        return DamageRelations(
            damageMap = mapOf(
                DamageType.DoubleDamageTo to getDamageValues(
                    DamageType.DoubleDamageTo,
                    doubleDamageTo,
                ),
                DamageType.DoubleDamageFrom to getDamageValues(
                    DamageType.DoubleDamageFrom,
                    doubleDamageFrom,
                ),
                DamageType.HalfDamageTo to getDamageValues(DamageType.HalfDamageTo, halfDamageTo),
                DamageType.HalfDamageFrom to getDamageValues(
                    DamageType.HalfDamageFrom,
                    halfDamageFrom,
                ),
                DamageType.NoDamageTo to getDamageValues(DamageType.NoDamageTo, noDamageTo),
                DamageType.NoDamageFrom to getDamageValues(DamageType.NoDamageFrom, noDamageFrom),
            ),
        )
    }

    private fun getDamageValues(damageType: DamageType, details: List<DetailsDTO>): DamageValues {
        return DamageValues(
            damageType = DamageTypeText(
                type = damageType.type,
                dttID = damageType.ordinal,
            ),
            details = details.map { detailsMapper(it) },
        )
    }
}
