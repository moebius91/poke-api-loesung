package com.syntax_institut.android_ta_apiwdh.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_ta_apiwdh.data.model.Pokemon
import com.syntax_institut.android_ta_apiwdh.data.remote.PokeApi
import java.lang.Exception

class AppRepository(private val apiService: PokeApi) {

    private var _pokeList = MutableLiveData<List<Pokemon>>()
    val pokeList: LiveData<List<Pokemon>>
        get() = _pokeList

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon>
        get() = _pokemon

    // Die ID wird noch einmal separat gespeichert,
    // weil das Attribut "order" aus der API nicht dem Kantopokedexindex entspricht.
    private var _pokeId = MutableLiveData<Int>()
    val pokeId: LiveData<Int>
        get() = _pokeId

    suspend fun getPokemonById(id: Int) {
        val pokemon = apiService.retrofitService.getPokemonById(id)
        _pokemon.postValue(pokemon)
    }

    suspend fun getAllPokemon() {
        val pokedex = apiService.retrofitService.getAllPokemon("151")
        _pokeList.postValue(pokedex.results)
    }

    fun saveId(id: Int) {
        _pokeId.postValue(id)
    }
}