package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.usecase.CheckNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val checkNameUseCase: CheckNameUseCase
): ViewModel() {

    private val _nameIsRegistered: MutableLiveData<Boolean> = MutableLiveData()
    val nameIsRegistered: LiveData<Boolean> = _nameIsRegistered

    @SuppressLint("SuspiciousIndentation")
    fun checkName(firstName: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = checkNameUseCase(firstName = firstName)
        withContext(Dispatchers.Main) {
            result.let {
                _nameIsRegistered.value = result ?: false
            }
        }
    }


}