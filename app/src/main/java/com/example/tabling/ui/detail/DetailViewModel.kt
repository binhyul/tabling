package com.example.tabling.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabling.domain.ClickLikeShopUseCase
import com.example.tabling.ui.main.ShopModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val clickLikeShopUseCase: ClickLikeShopUseCase
) : ViewModel() {

    val shopModel = savedStateHandle.getLiveData<ShopModel>(DETAIL_MODEL)


    fun onClickLike() {
        viewModelScope.launch {
            clickLikeShopUseCase(shopModel.value ?: return@launch)
                .onSuccess {
                    savedStateHandle[DETAIL_MODEL] = it
                }
                .onFailure { it.printStackTrace() }
        }
    }

    companion object {
        const val DETAIL_MODEL = "model"
    }

}