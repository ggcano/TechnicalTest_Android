package com.example.technicaltest_android.repository

import com.example.technicaltest_android.model.Pokemon

interface PokemonRepository {
    fun generatePokemonList(): MutableList<Pokemon>
}