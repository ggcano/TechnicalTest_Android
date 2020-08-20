package com.example.technicaltest_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest_android.model.Account
import com.example.technicaltest_android.repository.AccountRepositoryImpl

class AccountNoVisibleViewModel: ViewModel() {
    private val repo = AccountRepositoryImpl()
    val entities = mutableListOf<Account>()

    fun userData(): MutableLiveData<MutableList<Account>> {
        val mutableData = MutableLiveData<MutableList<Account>>()
        repo.getAccountFromApi().observeForever { accountList ->
            mutableData.value = accountList

        }
        return mutableData

    }

}