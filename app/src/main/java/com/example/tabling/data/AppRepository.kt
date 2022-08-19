package com.example.tabling.data

import com.example.tabling.local.model.ShopEntity
import com.example.tabling.remote.model.ShopItemModel

interface AppRepository {

    suspend fun getShopList(): List<ShopItemModel>

    suspend fun getRecentShopList(): List<ShopItemModel>

    suspend fun getLikeShopList(): List<ShopEntity>

    suspend fun likeShop(shop: ShopEntity)

    suspend fun unLikeShop(id: Int)
}