package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login.viewmodel.LoginViewModel
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
}