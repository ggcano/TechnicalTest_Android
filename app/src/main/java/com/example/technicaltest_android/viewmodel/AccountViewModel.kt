package com.example.technicaltest_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest_android.model.Pokemon
import com.example.technicaltest_android.repository.PokemonRepositoryImpl



class AccountViewModel() : ViewModel() {

    private val mutableList: MutableLiveData<MutableList<Pokemon>>
    private val repository: PokemonRepositoryImpl = PokemonRepositoryImpl()




    init {
        mutableList = repository.getPokemonsFromApi()
    }

    fun getPokemonReceived(): LiveData<MutableList<Pokemon>> {
        return mutableList
    }



}

