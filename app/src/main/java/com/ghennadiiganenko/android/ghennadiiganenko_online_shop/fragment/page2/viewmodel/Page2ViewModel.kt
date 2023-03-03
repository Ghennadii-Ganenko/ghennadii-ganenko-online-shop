package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.DetailsEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase.GetDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Page2ViewModel(
    private val getDetailsUseCase: GetDetailsUseCase
) : ViewModel() {

    private val _details: MutableLiveData<DetailsEntity> = MutableLiveData()
    val details: LiveData<DetailsEntity> = _details

    @SuppressLint("SuspiciousIndentation")
    fun getDetails() = viewModelScope.launch(Dispatchers.IO) {
        val result = getDetailsUseCase()
        withContext(Dispatchers.Main) {
            result?.let {
                _details.value = result ?: DetailsEntity(listOf(), "", listOf(), "", 0, 0, 0.0)
            }
        }
    }
}