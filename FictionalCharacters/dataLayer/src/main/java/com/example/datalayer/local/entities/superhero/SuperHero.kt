package com.example.datalayer.local.entities.superhero

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class SuperHero(
    val id: String,
    val name: String,
    @Embedded() val appearance: Appearance,
    @Embedded() val biography: Biography,
    @Embedded() val connections: Connections,
    @Embedded() val image: Image,
    @Embedded() val powerStats: Powerstats,
    @Embedded() val work: Work,
)
