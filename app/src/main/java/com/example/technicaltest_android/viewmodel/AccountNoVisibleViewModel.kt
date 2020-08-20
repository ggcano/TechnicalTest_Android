package com.example.technicaltest_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest_android.model.Pokemon
import com.example.technicaltest_android.repository.PokemonRepositoryImpl

class AccountNoVisibleViewModel: ViewModel() {
    private val repo = PokemonRepositoryImpl()
    val entities = mutableListOf<Pokemon>()

    fun userData(): MutableLiveData<MutableList<Pokemon>> {
        val mutableData = MutableLiveData<MutableList<Pokemon>>()
        repo.getPokemonsFromApi().observeForever { accountList ->
            mutableData.value = accountList

        }
        return mutableData

    }

    fun hhhh(): ArrayList<Pokemon> {
        val loquesea = ArrayList<Pokemon>()
        for (caca in entities) {
            if (caca.isVisibleAcoount == false) {
                loquesea.add(caca)

            }

        }
        return loquesea
    }
}