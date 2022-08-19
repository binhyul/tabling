package com.example.tabling.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.example.tabling.domain.LoadTabDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TablingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val loadTabDataUseCase: LoadTabDataUseCase
) : ViewModel() {

    val selectedTab: LiveData<TabType> = savedStateHandle.getLiveData(SELECTED_TAB)

    private val saveShopList: LiveData<List<ShopModel>> =
        savedStateHandle.getLiveData(SAVE_SHOP_LIST)

    private val recentShopList: LiveData<List<ShopModel>> =
        savedStateHandle.getLiveData(RECENT_SHOP_LIST)

    private val likeShopList: LiveData<List<ShopModel>> =
        savedStateHandle.getLiveData(LIKE_SHOP_LIST)

    init {
        onSelectTab(TabType.SAVE)
    }

    fun tabItems(tabType: TabType) = when (tabType) {
        TabType.SAVE -> saveShopList
        TabType.RECENT -> recentShopList
        else -> likeShopList
    }

    fun loadTabData(tabType: TabType) {
        viewModelScope.launch {
            loadTabDataUseCase(tabType).runCatching {
                onSuccess {
                    when (tabType) {
                        TabType.SAVE -> {
                            savedStateHandle[SAVE_SHOP_LIST] = it
                        }
                        TabType.RECENT -> {
                            savedStateHandle[RECENT_SHOP_LIST] = it
                        }
                        TabType.LIKE -> {
                            savedStateHandle[LIKE_SHOP_LIST] = it
                        }
                    }
                }.onFailure {
                    it.printStackTrace()
                }
            }
        }
    }

    fun onSelectTab(tabType: TabType) {
        savedStateHandle[SELECTED_TAB] = tabType
    }

    companion object {
        const val SELECTED_TAB = "selected_tab"
        const val SAVE_SHOP_LIST = "save_shop_list"
        const val RECENT_SHOP_LIST = "recent_shop_list"
        const val LIKE_SHOP_LIST = "like_shop_list"
    }

}