package com.example.tabling.domain

import android.util.Log
import com.example.tabling.data.AppRepository
import com.example.tabling.local.model.toModel
import com.example.tabling.remote.model.ShopItemModel
import com.example.tabling.remote.model.toEntity
import com.example.tabling.ui.main.ShopModel
import com.example.tabling.ui.main.TabType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class LoadTabDataUseCase @Inject constructor(
    private val appRepository: AppRepository
) : UseCase<TabType, List<ShopModel>>() {

    override suspend fun execute(parameters: TabType): List<ShopModel> {
        return withContext(Dispatchers.IO) {
            when (parameters) {
                TabType.SAVE -> appRepository.getShopList().map {
                    it.findLikeShop()
                }
                TabType.LIKE -> appRepository.getLikeShopList().map {
                    it.toModel()
                }
                TabType.RECENT -> appRepository.getRecentShopList().map {
                    it.findLikeShop()
                }
            }
        }
    }

    private suspend fun ShopItemModel.findLikeShop(): ShopModel {
        return if (id != null) {
            val findLikeShop = appRepository.findShop(id)?.toModel()
            findLikeShop ?: toEntity(false)
        } else {
            toEntity(false)
        }
    }
}


