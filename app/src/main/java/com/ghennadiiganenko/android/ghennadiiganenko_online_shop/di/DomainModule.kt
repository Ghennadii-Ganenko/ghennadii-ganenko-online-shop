package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.mapper.UserMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository.IUserRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository.UserRepositoryImpl
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase.*
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.FlashSaleMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.LatestMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase.GetFlashSaleUseCase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase.GetLatestUseCase
import org.koin.dsl.module

val domainModule = module {
    single<IUserRepository> { UserRepositoryImpl(get()) }

    single { UserMapper() }

    single { LatestMapper() }

    single { FlashSaleMapper() }

    //Data
    factory { AddUserUseCase(get(), get()) }

    factory { DeleteUserUseCase(get(), get()) }

    factory { GetAllUsersUseCase(get(), get()) }

    factory { GetUserUseCase(get(), get()) }

    factory { CheckUserUseCase(get(), get()) }

    factory { CheckNameUseCase(get()) }

    //Network
    factory { GetLatestUseCase( get(), get()) }

    factory { GetFlashSaleUseCase( get(), get()) }
}