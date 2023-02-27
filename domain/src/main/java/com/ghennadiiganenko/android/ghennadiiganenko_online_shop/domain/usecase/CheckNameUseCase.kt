package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository.IUserRepository

class CheckNameUseCase(private val userRepository: IUserRepository) {

    suspend operator fun invoke(firstName: String): Boolean = userRepository.isNameRegistered(firstName)

}