package com.example.datalayer.network.dtos.pokemondtos.pokemon

import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.DetailsDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponseDTO(
    val abilities: List<AbilityDTO>,
    @SerialName("base_experience")
    val baseExperience: Int,
    val forms: List<DetailsDTO>,
    val height: Int,
    val id: Int,
    @SerialName("is_default")
    val isDefault: Boolean,
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<MoveDTO>,
    val name: String,
    val order: Int,
    @SerialName("past_types")
    val pastTypes: List<PastTypeDTO>,
    val species: DetailsDTO,
    val sprites: SpritesDTO,
    val stats: List<StatDTO>,
    val types: List<PokemonTypeDTO>,
    val weight: Int,
)
