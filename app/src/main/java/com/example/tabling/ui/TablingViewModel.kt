package com.example.tabling.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.tabling.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TablingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AppRepository
) : ViewModel() {

}