package com.example.tabling.ui.main

import android.os.Parcelable
import com.example.tabling.R
import com.example.tabling.local.model.ShopEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopModel(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val rating: Float,
    val reviewCount: Int,
    val place: String,
    val category: String,
    val waitingTeamCount: Int,
    val tagStringRes: List<Int>? = null,
    val like: Boolean
) : Parcelable

fun ShopModel.toEntity() = ShopEntity(
    id,
    thumbnail,
    category,
    title,
    rating,
    reviewCount,
    place,
    tagStringRes?.find { it == R.string.quick_booking_tag } != null,
    tagStringRes?.find { it == R.string.remote_waiting_tag } != null,
    waitingTeamCount
)
