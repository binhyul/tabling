package com.example.tabling.ui.main

import android.os.Parcelable
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
    val waitingTeamCount : Int,
    val tagStringRes: List<Int>? = null
) : Parcelable