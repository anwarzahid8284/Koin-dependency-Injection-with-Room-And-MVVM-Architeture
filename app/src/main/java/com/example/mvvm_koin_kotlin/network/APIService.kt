package com.example.mvvm_koin_kotlin.network

import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun getAllCountries(): Response<List<NetworkData>>
}