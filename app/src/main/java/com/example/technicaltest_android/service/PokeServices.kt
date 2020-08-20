package com.example.technicaltest_android.service

import com.example.technicaltest_android.dto.AccountListDTO
import retrofit2.Call
import retrofit2.http.GET

interface PokeServices {
    @GET("78c16efb-9e28-41ba-b377-19f9b6d30da2")
    fun getAccountList(): Call<AccountListDTO>
}