package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Image
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.ImageDTO

class ImageMapper : Mapper<ImageDTO, Image> {
    override suspend fun invoke(entity: ImageDTO): Image {
        TODO("Not yet implemented")
    }
}
