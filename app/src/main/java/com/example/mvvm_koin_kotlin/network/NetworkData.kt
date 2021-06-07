package com.example.mvvm_koin_kotlin.network

import com.squareup.moshi.Json


data class NetworkData(
    @Json(name = "userID")
    val userID: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "body")
    val body: String = ""
)