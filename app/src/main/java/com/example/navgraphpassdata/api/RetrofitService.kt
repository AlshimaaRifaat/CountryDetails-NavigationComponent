package com.example.navgraphpassdata.api

import io.reactivex.Single
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("rest/v2/all")
    fun fetchCharacterName(): Single<Response<List<CountryDetails>>>


}