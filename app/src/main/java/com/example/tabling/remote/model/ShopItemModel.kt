package com.example.tabling.remote.model

import com.example.tabling.R
import com.example.tabling.ui.main.ShopModel
import com.google.gson.annotations.SerializedName


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

fun getShopModelTags(isQuickBooking: Boolean?, isRemoteWaiting: Boolean?): List<Int> {
    val tagStringRes: MutableList<Int> = mutableListOf()
    isQuickBooking?.let {
        if (it) tagStringRes.add(R.string.quick_booking_tag)
    }
    isRemoteWaiting?.let {
        if (it) tagStringRes.add(R.string.remote_waiting_tag)
    }
    return tagStringRes
}

fun ShopItemModel.toEntity(like: Boolean) = ShopModel(
    id = id ?: throw IllegalStateException("shop id is not nullable"),
    title = restaurantName.orEmpty(),
    thumbnail = thumbnail.orEmpty(),
    rating = rating ?: 0f,
    reviewCount = reviewCount ?: 0,
    place = summaryAddress.orEmpty(),
    category = classification.orEmpty(),
    waitingTeamCount = waitingCount ?: 0,
    tagStringRes = getShopModelTags(isQuickBooking, isRemoteWaiting),
    like = like
)