package com.example.tabling.local.source

import com.example.tabling.local.ShopDao
import com.example.tabling.local.model.ShopEntity
import javax.inject.Inject

class AppLocalDataSourceImpl @Inject constructor(
    private val shopDao: ShopDao
) : AppLocalDataSource {
    override suspend fun getLikeShopList(): List<ShopEntity> = shopDao.getShopList()

    override suspend fun likeShop(shop: ShopEntity) = shopDao.insertShop(shop)

    override suspend fun unLikeShop(id: Int) = shopDao.deleteShop(id)
}