package com.wikicoding.loginexamplecompose.apiService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService(token: String) {
    private val BASE_URL: String = "http://192.168.1.70:3000"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(token))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiCallService: RetrofitDao = retrofit.create(RetrofitDao::class.java)
}