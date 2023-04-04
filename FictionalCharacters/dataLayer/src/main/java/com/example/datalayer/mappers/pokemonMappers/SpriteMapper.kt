package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.pokemonDetails.Sprites
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.pokemon.SpritesDTO

class SpriteMapper : Mapper<SpritesDTO, Sprites> {
    override suspend fun invoke(entity: SpritesDTO): Sprites = with(entity) {
        return Sprites(
            backDefault,
            backFemale,
            backShiny,
            backShinyFemale,
            frontDefault,
            frontFemale,
            frontShiny,
            frontShinyFemale,
        )
    }
}
