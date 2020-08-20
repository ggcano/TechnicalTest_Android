package com.example.technicaltest_android.dto

import com.google.gson.annotations.SerializedName

    data class AccountListDTO (
        @SerializedName("accounts")
        val accountListDTO: MutableList<AccountsDTO>
    )