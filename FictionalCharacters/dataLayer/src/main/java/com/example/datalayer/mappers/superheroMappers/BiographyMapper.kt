package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Biography
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.BiographyDTO

class BiographyMapper : Mapper<BiographyDTO, Biography> {
    override suspend fun invoke(entity: BiographyDTO): Biography {
        TODO("Not yet implemented")
    }
}
