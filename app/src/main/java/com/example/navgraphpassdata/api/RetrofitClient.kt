package com.example.navgraphpassdata.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitClient {
    companion object {
        fun getRetrofitInstance(): RetrofitService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}