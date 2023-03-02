package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.profile.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase.GetUserUseCase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase.UpdatePictureUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(
    private val updatePictureUseCase: UpdatePictureUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> = _user

    fun updatePicture(picture: String, firstName: String) = viewModelScope.launch(Dispatchers.IO) {
        updatePictureUseCase(picture = picture, firstName = firstName)
    }

    @SuppressLint("SuspiciousIndentation")
    fun getUser(firstName: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = getUserUseCase(firstName = firstName)
        withContext(Dispatchers.Main) {
            result.let {
                _user.value = result ?: User(0,"","","","")
            }
        }
    }
}