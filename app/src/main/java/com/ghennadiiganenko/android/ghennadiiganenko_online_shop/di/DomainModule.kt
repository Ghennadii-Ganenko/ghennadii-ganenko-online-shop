package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.mapper.UserMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository.IUserRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository.UserRepositoryImpl
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {
    single<IUserRepository> { UserRepositoryImpl(get()) }

    single { UserMapper() }

    factory { AddUserUseCase(get(), get()) }

    factory { DeleteUserUseCase(get(), get()) }

    factory { GetAllUsersUseCase(get(), get()) }

    factory { GetUserUseCase(get(), get()) }

    factory { CheckUserUseCase(get(), get()) }

    factory { CheckNameUseCase(get()) }
}