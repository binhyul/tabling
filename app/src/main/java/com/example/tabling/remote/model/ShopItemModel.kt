package com.example.tabling.remote.model

import com.example.tabling.R
import com.example.tabling.ui.ShopModel
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

fun getShopModelTags(model: ShopItemModel): List<Int> {
    val tagStringRes: MutableList<Int> = mutableListOf()
    model.isQuickBooking?.let {
        if (it) tagStringRes.add(R.string.quick_booking_tag)
    }
    model.isRemoteWaiting?.let {
        if (it) tagStringRes.add(R.string.remote_waiting_tag)
    }
    return tagStringRes
}

fun ShopItemModel.toEntity() = ShopModel(
    id = id ?: throw IllegalStateException("shop id is not nullable"),
    title = restaurantName.orEmpty(),
    thumbnail = thumbnail.orEmpty(),
    rating = rating ?: 0f,
    reviewCount = reviewCount ?: 0,
    place = summaryAddress.orEmpty(),
    category = classification.orEmpty(),
    waitingTeamCount = waitingCount ?: 0,
    tagStringRes = getShopModelTags(this)
)