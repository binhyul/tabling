package com.example.tabling.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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
    val useWaiting: Boolean?,
    val useBooking: Boolean?,
    val waitingCount: Int?
)