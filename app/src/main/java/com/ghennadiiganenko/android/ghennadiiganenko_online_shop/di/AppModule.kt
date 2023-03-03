package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login.viewmodel.LoginViewModel
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.viewmodel.Page1ViewModel
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2.viewmodel.Page2ViewModel
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.profile.viewmodel.ProfileViewModel
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.sign.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<SignInViewModel> {
        SignInViewModel(
            addUserUseCase = get(),
            checkUserUseCase = get()
        )
    }

    viewModel<LoginViewModel> {
        LoginViewModel(
            checkNameUseCase = get()
        )
    }

    viewModel<Page1ViewModel> {
        Page1ViewModel(
            getLatestUseCase = get(),
            getFlashSaleUseCase = get(),
            getUserUseCase = get()
        )
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel(
            updatePictureUseCase = get(),
            getUserUseCase = get()
        )
    }

    viewModel<Page2ViewModel> {
        Page2ViewModel(
            getDetailsUseCase = get()
        )
    }
}