package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Powerstats
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.PowerstatsDTO

class PowerstatsMapper : Mapper<PowerstatsDTO, Powerstats> {
    override suspend fun invoke(entity: PowerstatsDTO): Powerstats {
        TODO("Not yet implemented")
    }
}
