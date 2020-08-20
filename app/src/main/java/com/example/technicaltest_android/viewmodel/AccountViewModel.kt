package com.example.technicaltest_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaltest_android.model.Account
import com.example.technicaltest_android.repository.AccountRepositoryImpl



class AccountViewModel : ViewModel() {

    private val mutableList: MutableLiveData<MutableList<Account>>
    private val repository: AccountRepositoryImpl = AccountRepositoryImpl()

    init {
        mutableList = repository.getAccountFromApi()
    }

    fun getAccountReceived(): LiveData<MutableList<Account>> {
        return mutableList
    }

}

