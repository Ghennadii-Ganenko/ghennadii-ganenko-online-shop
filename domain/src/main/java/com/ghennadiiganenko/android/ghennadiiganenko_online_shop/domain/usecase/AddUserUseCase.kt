package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.mapper.UserMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository.IUserRepository

class AddUserUseCase(private val userRepository: IUserRepository, private val userMapper: UserMapper) {

    suspend operator fun invoke(user: User) {
        userRepository.addUser(userMapper.mapToEntity(user))
    }

}