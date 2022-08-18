package com.example.tabling.data

import com.example.tabling.remote.model.ShopItemModel

interface AppRepository {

    suspend fun getShopList(): List<ShopItemModel>

    suspend fun getRecentShopList(): List<ShopItemModel>
}