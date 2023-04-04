package com.example.datalayer.mappers.pokemonMappers

import com.example.datalayer.local.entities.pokemon.type.Type
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.pokemondtos.type.TypeDTO

class TypeMapper : Mapper<TypeDTO, Type> {
    override suspend fun invoke(entity: TypeDTO): Type = with(entity) {
        return Type(name, url)
    }
}
