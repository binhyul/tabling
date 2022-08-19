package com.example.tabling.local.source

import com.example.tabling.local.model.ShopEntity


interface AppLocalDataSource {

    suspend fun getLikeShopList(): List<ShopEntity>

    suspend fun findShop(id: Int): ShopEntity?

    suspend fun likeShop(shop: ShopEntity)

    suspend fun unLikeShop(id: Int)
}