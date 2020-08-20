package com.example.technicaltest_android.repository

import com.example.technicaltest_android.model.Account

interface Repository {
    fun generateAccountList(): MutableList<Account>
}