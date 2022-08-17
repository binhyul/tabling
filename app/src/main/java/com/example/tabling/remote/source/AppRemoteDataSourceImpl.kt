package com.example.tabling.remote.source

import com.example.tabling.remote.AppService
import com.example.tabling.remote.ShopItemModel
import javax.inject.Inject

class AppRemoteDataSourceImpl @Inject constructor(
    private val appService: AppService
) : AppRemoteDataSource {

    override suspend fun getRecentShopList(): List<ShopItemModel> = appService.getRecentShopList().items

    override suspend fun getShopList(): List<ShopItemModel> = appService.getShopList().items
}