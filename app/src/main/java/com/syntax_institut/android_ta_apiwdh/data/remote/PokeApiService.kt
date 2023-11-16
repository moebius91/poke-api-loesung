package com.syntax_institut.android_ta_apiwdh.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.android_ta_apiwdh.data.model.PokeResult
import com.syntax_institut.android_ta_apiwdh.data.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://pokeapi.co/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PokeApiService {

    @GET("pokemon")
    suspend fun getAllPokemon(@Query("limit") limit: String): PokeResult

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon
}

object PokeApi {
    val retrofitService: PokeApiService by lazy { retrofit.create(PokeApiService::class.java) }
}