package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Connections
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.ConnectionsDTO

class ConnectionsMapper : Mapper<ConnectionsDTO, Connections> {
    override suspend fun invoke(entity: ConnectionsDTO): Connections {
        TODO("Not yet implemented")
    }
}
