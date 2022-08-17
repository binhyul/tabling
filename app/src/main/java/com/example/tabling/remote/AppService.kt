package com.example.tabling.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface AppService {

    @GET("/save")
    suspend fun getShopList(): ShopListResponse

    @GET("/recent")
    suspend fun getRecentShopList(): ShopListResponse

}


data class ShopListResponse(
    @SerializedName("list") val items: List<ShopItemModel>,
)

data class ShopItemModel(
    @SerializedName("restaurantIdx") val id: Int?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("classification") val classification: String?,
    @SerializedName("restaurantName") val restaurantName: String?,
    @SerializedName("rating") val rating: Float?,
    @SerializedName("reviewCount") val reviewCount: Int?,
    @SerializedName("summaryAddress") val summaryAddress: String?,
    @SerializedName("isQuickBooking") val isQuickBooking: Boolean?,
    @SerializedName("isRemoteWaiting") val isRemoteWaiting: Boolean?,
    @SerializedName("useWaiting") val useWaiting: Boolean?,
    @SerializedName("useBooking") val useBooking: Boolean?,
    @SerializedName("isNew") val isNew: Boolean?,
    @SerializedName("waitingCount") val waitingCount: Int?
)