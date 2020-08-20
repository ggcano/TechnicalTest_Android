package com.example.technicaltest_android.dto

import com.google.gson.annotations.SerializedName

data class AccountsDTO(

    @SerializedName("accountBalanceInCents")
    val balanceId: Int,

    @SerializedName("accountName")
    val accountName: String,

    @SerializedName("isVisible")
    val isVisible: Boolean,

    @SerializedName("iban")
    val iban: String

)