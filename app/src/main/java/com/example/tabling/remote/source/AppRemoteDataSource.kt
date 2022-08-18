package com.example.tabling.remote.source

import com.example.tabling.remote.model.ShopItemModel


interface AppRemoteDataSource {

    suspend fun getShopList(): List<ShopItemModel>

    suspend fun getRecentShopList(): List<ShopItemModel>
}