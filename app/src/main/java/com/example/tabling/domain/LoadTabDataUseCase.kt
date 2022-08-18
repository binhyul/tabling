package com.example.tabling.domain

import com.example.tabling.data.AppRepository
import com.example.tabling.ui.ShopModel
import com.example.tabling.ui.TabType
import javax.inject.Inject


class LoadTabDataUseCase @Inject constructor(
    private val appRepository: AppRepository
) : UseCase<TabType, List<ShopModel>>() {

    override suspend fun execute(parameters: TabType): List<ShopModel> {
        return when (parameters) {
            TabType.SAVE -> appRepository.getShopList().map {
                ShopModel(
                    id = it.id ?: throw IllegalStateException("shop id is not nullable"),
                    title = it.restaurantName.orEmpty()
                )
            }
            TabType.LIKE -> {
                emptyList()
            }
            TabType.RECENT -> appRepository.getRecentShopList().map {
                ShopModel(
                    id = it.id ?: throw IllegalStateException("shop id is not nullable"),
                    title = it.restaurantName.orEmpty()
                )
            }
        }
    }
}


