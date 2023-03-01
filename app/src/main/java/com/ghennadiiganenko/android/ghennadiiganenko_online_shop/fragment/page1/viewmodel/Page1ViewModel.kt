package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleDataEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestDataEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase.GetFlashSaleUseCase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase.GetLatestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Page1ViewModel(
    private val getLatestUseCase: GetLatestUseCase,
    private val getFlashSaleUseCase: GetFlashSaleUseCase
): ViewModel() {

    private val _latestList: MutableLiveData<LatestDataEntity> = MutableLiveData()
    val latestList: LiveData<LatestDataEntity> = _latestList

    private val _flashSaleList: MutableLiveData<FlashSaleDataEntity> = MutableLiveData()
    val flashSaleList: LiveData<FlashSaleDataEntity> = _flashSaleList

    @SuppressLint("SuspiciousIndentation")
    fun getLatestList() = viewModelScope.launch(Dispatchers.IO) {
        val result = getLatestUseCase()
            withContext(Dispatchers.Main) {
                result?.let {
                    _latestList.value = result ?: LatestDataEntity(listOf())
                }
            }
    }

    @SuppressLint("SuspiciousIndentation")
    fun getFlashSaleList() = viewModelScope.launch(Dispatchers.IO) {
        val result = getFlashSaleUseCase()
        withContext(Dispatchers.Main) {
            result?.let {
                _flashSaleList.value = result ?: FlashSaleDataEntity(listOf())
            }
        }
    }
}