package com.example.tabling.remote

import com.example.tabling.remote.model.ShopListResponse
import retrofit2.http.GET

interface AppService {

    @GET("save")
    suspend fun getShopList(): ShopListResponse

    @GET("recent")
    suspend fun getRecentShopList(): ShopListResponse

}

