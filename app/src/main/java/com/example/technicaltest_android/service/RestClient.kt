package com.example.technicaltest_android.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {
    private val TAG = "Network"
    private val CONNECT_TIMEOUT = 20000
    private val WRITE_TIMEOUT = 20000
    private val READ_TIMEOUT = 20000

    private lateinit var service: Services
    private val baseUrl = "https://run.mocky.io/v3/"

    //FULL URL
    //https://run.mocky.io/v3/78c16efb-9e28-41ba-b377-19f9b6d30da2

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor =  HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = okHttpClient.addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        initServices(retrofit)
    }

    fun getAccountServices(): Services {

        return service
    }

    private fun initServices (retrofit: Retrofit) {
        service = retrofit.create(Services::class.java)
    }
}