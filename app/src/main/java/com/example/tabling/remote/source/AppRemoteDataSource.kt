package com.example.tabling.remote.source

import androidx.paging.PagingData
import com.example.tabling.remote.ShopItemModel
import kotlinx.coroutines.flow.Flow

interface AppRemoteDataSource {

    suspend fun getShopList(): List<ShopItemModel>

    suspend fun getRecentShopList(): List<ShopItemModel>
}