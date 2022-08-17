package com.example.tabling.remote.source

import com.example.tabling.remote.ShopItemModel

interface AppRemoteDataSource {

    suspend fun getShopList(): List<ShopItemModel>

    suspend fun getRecentShopList(): List<ShopItemModel>
}