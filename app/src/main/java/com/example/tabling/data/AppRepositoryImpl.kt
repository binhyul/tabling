package com.example.tabling.data

import com.example.tabling.remote.model.ShopItemModel
import com.example.tabling.remote.source.AppRemoteDataSource
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val dataSource: AppRemoteDataSource
) : AppRepository {

    override suspend fun getShopList(): List<ShopItemModel> = dataSource.getShopList()

    override suspend fun getRecentShopList(): List<ShopItemModel> = dataSource.getRecentShopList()
}