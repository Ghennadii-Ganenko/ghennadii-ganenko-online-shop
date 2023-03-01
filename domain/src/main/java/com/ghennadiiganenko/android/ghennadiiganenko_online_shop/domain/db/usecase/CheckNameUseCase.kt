package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository.IUserRepository

class CheckNameUseCase(private val userRepository: IUserRepository) {

    suspend operator fun invoke(firstName: String): Boolean = userRepository.isNameRegistered(firstName)

}