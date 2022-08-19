package com.example.tabling.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tabling.remote.model.getShopModelTags
import com.example.tabling.ui.main.ShopModel

@Entity(tableName = "shop")
data class ShopEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val thumbnail: String?,
    val classification: String?,
    val name: String?,
    val rating: Float?,
    val reviewCount: Int?,
    val summaryAddress: String?,
    val quickBooking: Boolean?,
    val remoteWaiting: Boolean?,
    val waitingCount: Int?
)

fun ShopEntity.toModel() = ShopModel(
    id = id ?: throw IllegalStateException("shop id is not nullable"),
    title = name.orEmpty(),
    thumbnail = thumbnail.orEmpty(),
    rating = rating ?: 0f,
    reviewCount = reviewCount ?: 0,
    place = summaryAddress.orEmpty(),
    category = classification.orEmpty(),
    waitingTeamCount = waitingCount ?: 0,
    tagStringRes = getShopModelTags(quickBooking, remoteWaiting),
    like = true
)