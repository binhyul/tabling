package com.example.tabling.data

import com.example.tabling.local.model.ShopEntity
import com.example.tabling.local.source.AppLocalDataSource
import com.example.tabling.remote.model.ShopItemModel
import com.example.tabling.remote.source.AppRemoteDataSource
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val dataSource: AppRemoteDataSource,
    private val localDataSource: AppLocalDataSource
) : AppRepository {

    override suspend fun getShopList(): List<ShopItemModel> = dataSource.getShopList()

    override suspend fun getRecentShopList(): List<ShopItemModel> = dataSource.getRecentShopList()

    override suspend fun getLikeShopList(): List<ShopEntity> = localDataSource.getLikeShopList()

    override suspend fun findShop(id: Int): ShopEntity? = localDataSource.findShop(id)

    override suspend fun likeShop(shop: ShopEntity) = localDataSource.likeShop(shop)

    override suspend fun unLikeShop(id: Int) = localDataSource.unLikeShop(id)
}