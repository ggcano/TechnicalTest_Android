package com.example.technicaltest_android.dto

import com.example.technicaltest_android.model.Pokemon
import java.util.ArrayList

object Mapper {

    fun toListDomain(dtoList: AccountListDTO ): MutableList<Pokemon> {
        val entities = ArrayList<Pokemon>()

        for (dto in dtoList.accountListDTO) {
            entities.add(entityFrom(dto))
        }
        return entities
    }

    fun entityFrom (dto: AccountsDTO):Pokemon {

        return Pokemon(dto.iban, dto.balanceId.toString(),dto.accountName,dto.isVisible)
    }


}