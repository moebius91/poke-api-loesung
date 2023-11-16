package com.syntax_institut.android_ta_apiwdh.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.android_ta_apiwdh.data.AppRepository
import com.syntax_institut.android_ta_apiwdh.data.remote.PokeApi
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    private val repository = AppRepository(PokeApi)

    val pokemon = repository.pokemon
    val pokeList = repository.pokeList
    val pokeId = repository.pokeId

    init {
        loadPokeList()
    }

    private fun loadPokeList() {
        viewModelScope.launch {
            repository.getAllPokemon()
        }
    }

    fun loadPokemon(id: Int) {
        viewModelScope.launch {
            repository.getPokemonById(id)
        }
    }

    fun savePokeId(id: Int) {
        viewModelScope.launch {
            repository.saveId(id)
        }
    }

}