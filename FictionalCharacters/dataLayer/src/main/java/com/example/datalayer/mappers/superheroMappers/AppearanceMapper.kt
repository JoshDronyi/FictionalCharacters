package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.Appearance
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.AppearanceDTO

class AppearanceMapper : Mapper<AppearanceDTO, Appearance> {
    override suspend fun invoke(entity: AppearanceDTO): Appearance = with(entity) {
        return Appearance(
            eyeColor = eyeColor,
            gender = gender,
            hairColor = hairColor,
            race = race,
            weight = "${weight.first()}/ ${weight.last()}",
            height = "${height.first()}/ ${height.last()}",
        )
    }
}
