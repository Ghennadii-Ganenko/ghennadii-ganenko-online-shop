package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.mapper.UserMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository.IUserRepository

class GetAllUsersUseCase(private val userRepository: IUserRepository, private val userMapper: UserMapper) {

    suspend operator fun invoke(): List<User> = userRepository.getAll().map { userMapper.mapFromEntity(it) }

}