package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.utils.IEntityMapper

class UserMapper : IEntityMapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            uid = entity.uid,
            firstName = entity.firstName,
            lastName = entity.lastName,
            email = entity.email
        )
    }

    override fun mapToEntity(domainModel: User): UserEntity {
        return UserEntity(
            uid = domainModel.uid,
            firstName = domainModel.firstName,
            lastName = domainModel.lastName,
            email = domainModel.email
        )
    }
}