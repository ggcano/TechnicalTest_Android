package com.example.technicaltest_android.dto

import com.example.technicaltest_android.model.Account
import java.util.ArrayList

object Mapper {

    fun toListDomain(dtoList: AccountListDTO ): MutableList<Account> {
        val entities = ArrayList<Account>()

        for (dto in dtoList.accountListDTO) {
            entities.add(entityFrom(dto))
        }
        return entities
    }

    private fun entityFrom (dto: AccountsDTO):Account {

        return Account(dto.iban, dto.balanceId.toString(),dto.accountName,dto.isVisible)
    }


}