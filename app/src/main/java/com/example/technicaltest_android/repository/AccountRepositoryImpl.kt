package com.example.technicaltest_android.repository

import androidx.lifecycle.MutableLiveData
import com.example.technicaltest_android.dto.AccountListDTO
import com.example.technicaltest_android.dto.Mapper
import com.example.technicaltest_android.model.Account
import com.example.technicaltest_android.service.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountRepositoryImpl : Repository {
    private val restClient: RestClient = RestClient()

    override fun generateAccountList(): MutableList<Account> {
        return ArrayList()
    }

    fun getAccountFromApi(): MutableLiveData<MutableList<Account>> {
        val list: MutableLiveData<MutableList<Account>> = MutableLiveData()

        val call = restClient.getAccountServices().getAccountList()
        call.enqueue(object : Callback<AccountListDTO> {
            override fun onFailure(call: Call<AccountListDTO>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(
                call: Call<AccountListDTO>?,
                response: Response<AccountListDTO>?
            ) {
                list.value = Mapper.toListDomain(response?.body()!!)
            }
        })

        return list
    }


}



