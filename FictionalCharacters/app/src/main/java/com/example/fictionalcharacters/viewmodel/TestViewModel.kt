package com.example.fictionalcharacters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datalayer.local.entities.pokemon.pokemonDetails.PokemonResponse
import com.example.datalayer.local.entities.pokemon.type.Type
import com.example.datalayer.local.entities.superhero.SuperHero
import com.example.datalayer.network.dtos.pokemondtos.pokemonInType.PokemonInTypeResponse
import com.example.datalayer.repos.PokemonRepo
import com.example.datalayer.repos.SuperHeroRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TestViewModel(
    private val pokemonRepo: PokemonRepo,
    private val superHeroRepo: SuperHeroRepo,
) : ViewModel() {

    private val _dataState: MutableStateFlow<DataState> = MutableStateFlow(DataState())
    val dataState: StateFlow<DataState> get() = _dataState

    init {
        with(viewModelScope) {
            val typeJob = launch {
                val jawn = pokemonRepo.getTypes()
                _dataState.update {
                    it.copy(typeList = jawn)
                }
            }
            val pokemonInTypeJob = launch {
                val jawn = pokemonRepo.getPokemonInType()
                _dataState.update {
                    it.copy(pokemonInTypeList = jawn)
                }
            }
            val pokemonJob = launch {
                val jawn = pokemonRepo.getPokemon()
                _dataState.update {
                    it.copy(pokemonDetails = jawn)
                }
            }
            val superHeroJob = launch {
                val jawn = superHeroRepo.getHero("hulk")
                _dataState.update {
                    it.copy(superHeroList = jawn)
                }
            }
        }
    }
}

data class DataState(
    val pokemonDetails: PokemonResponse = PokemonResponse(),
    val pokemonInTypeList: PokemonInTypeResponse? = null,
    val typeList: List<Type> = emptyList(),
    val superHeroList: List<SuperHero> = emptyList(),
)
