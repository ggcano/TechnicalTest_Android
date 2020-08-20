package com.example.technicaltest_android.repository

import androidx.lifecycle.MutableLiveData
import com.example.technicaltest_android.dto.AccountListDTO
import com.example.technicaltest_android.dto.AccountsDTO
import com.example.technicaltest_android.dto.Mapper
import com.example.technicaltest_android.model.Pokemon
import com.example.technicaltest_android.service.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl : PokemonRepository {

    val restClient: RestClient = RestClient()

    override fun generatePokemonList(): MutableList<Pokemon> {
        val pokemones: MutableList<Pokemon> = ArrayList()


        return pokemones
    }

    fun getPokemonsFromApi(): MutableLiveData<MutableList<Pokemon>> {
        val mutableLiveData: MutableLiveData<MutableList<Pokemon>> = MutableLiveData()

        val call = restClient.getPokemonsServices().getAccountList()
        call.enqueue(object : Callback<AccountListDTO> {
            override fun onFailure(call: Call<AccountListDTO>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(
                call: Call<AccountListDTO>?,
                response: Response<AccountListDTO>?
            ) {
                mutableLiveData.value = Mapper.toListDomain(response?.body()!!)
            }
        })

        return mutableLiveData
    }


}



