package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Work
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.WorkDTO

class WorkMapper : Mapper<WorkDTO, Work> {
    override suspend fun invoke(entity: WorkDTO): Work {
        TODO("Not yet implemented")
    }
}
