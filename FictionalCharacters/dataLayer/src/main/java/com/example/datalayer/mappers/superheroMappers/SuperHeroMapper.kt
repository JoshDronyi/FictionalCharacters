package com.example.datalayer.mappers.superheroMappers

import com.example.datalayer.local.entities.superhero.SuperHero
import com.example.datalayer.mappers.Mapper
import com.example.datalayer.network.dtos.superherodtos.SuperHeroDTO

class SuperHeroMapper(
    val appearanceMapper: AppearanceMapper = AppearanceMapper(),
    val biographyMapper: BiographyMapper = BiographyMapper(),
    val connectionsMapper: ConnectionsMapper = ConnectionsMapper(),
    val imageMapper: ImageMapper = ImageMapper(),
    val powerstatsMapper: PowerstatsMapper = PowerstatsMapper(),
    val workMapper: WorkMapper = WorkMapper(),
) : Mapper<SuperHeroDTO, SuperHero> {
    override suspend fun invoke(entity: SuperHeroDTO): SuperHero = with(entity) {
        return SuperHero(
            id = id,
            name = name,
            appearance = appearanceMapper(appearance),
            biography = biographyMapper(biography),
            connections = connectionsMapper(connections),
            image = imageMapper(image),
            powerStats = powerstatsMapper(powerstats),
            work = workMapper(work),
        )
    }
}
