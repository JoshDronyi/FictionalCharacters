package com.example.datalayer.mappers

interface Mapper<in DTO, out Entity> {
    suspend operator fun invoke(entity: DTO): Entity
}
