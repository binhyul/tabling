package com.example.tabling.domain

import com.example.tabling.data.AppRepository
import com.example.tabling.remote.model.toEntity
import com.example.tabling.ui.main.ShopModel
import com.example.tabling.ui.main.TabType
import javax.inject.Inject


class LoadTabDataUseCase @Inject constructor(
    private val appRepository: AppRepository
) : UseCase<TabType, List<ShopModel>>() {

    override suspend fun execute(parameters: TabType): List<ShopModel> {
        return when (parameters) {
            TabType.SAVE -> appRepository.getShopList().map {
                it.toEntity()
            }
            TabType.LIKE -> {
                emptyList()
            }
            TabType.RECENT -> appRepository.getRecentShopList().map {
                it.toEntity()
            }
        }
    }
}


