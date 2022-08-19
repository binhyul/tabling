package com.example.tabling.domain

import com.example.tabling.data.AppRepository
import com.example.tabling.local.model.toModel
import com.example.tabling.ui.main.ShopModel
import com.example.tabling.ui.main.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClickLikeShopUseCase @Inject constructor(
    private val appRepository: AppRepository
) : UseCase<ShopModel, ShopModel>() {

    override suspend fun execute(parameters: ShopModel): ShopModel {
        return withContext(Dispatchers.Default) {
            if (!parameters.like) {
                appRepository.likeShop(parameters.toEntity())
            } else {
                appRepository.unLikeShop(parameters.id)
            }

            val shopModel = appRepository.findShop(parameters.id)
            shopModel?.toModel()

            shopModel?.toModel() ?: parameters.copy(
                like = shopModel != null
            )
        }
    }
}