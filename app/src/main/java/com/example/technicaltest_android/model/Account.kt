package com.example.technicaltest_android.model

import java.io.Serializable

data class Account (var IBAN: String,
                    var balance: String,
                    var accountName: String,
                    var isVisibleAcoount: Boolean)