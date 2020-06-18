package com.example.navgraphpassdata.data

import com.example.navgraphpassdata.api.RetrofitClient
import com.example.navgraphpassdata.api.RetrofitService
import io.reactivex.Single
import kulloveth.developer.com.countrydetails.data.model.CountryDetails
import retrofit2.Response

class CountryDetailsRepository {
    fun fetchCountryDetails(): Single<Response<List<CountryDetails>>> {
        return RetrofitClient.getRetrofitInstance().fetchCharacterName()
    }
}