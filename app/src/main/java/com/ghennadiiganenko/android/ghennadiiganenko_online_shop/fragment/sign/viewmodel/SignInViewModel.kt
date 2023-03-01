package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.sign.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase.AddUserUseCase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase.CheckUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(
    private val addUserUseCase: AddUserUseCase,
    private val checkUserUseCase: CheckUserUseCase
) : ViewModel() {

    private val _isRegistered: MutableLiveData<Boolean> = MutableLiveData()
    val isRegistered: LiveData<Boolean> = _isRegistered

    @SuppressLint("SuspiciousIndentation")
    fun checkUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        val result = checkUserUseCase(user = user)
            withContext(Dispatchers.Main) {
                result.let {
                    _isRegistered.value = result ?: false
                }
            }
    }

    fun addUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        addUserUseCase(user = user)
    }
}