package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.mapper.UserMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository.IUserRepository

class GetUserUseCase(private val userRepository: IUserRepository, private val userMapper: UserMapper) {

    suspend operator fun invoke(firstName: String): User = userMapper.mapFromEntity(userRepository.getUser(firstName))

}