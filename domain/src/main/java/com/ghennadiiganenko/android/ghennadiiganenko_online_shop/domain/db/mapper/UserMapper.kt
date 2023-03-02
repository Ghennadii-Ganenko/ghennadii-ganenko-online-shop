package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.utils.IEntityMapper

class UserMapper : IEntityMapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            uid = entity.uid,
            firstName = entity.firstName,
            lastName = entity.lastName,
            email = entity.email,
            picture = entity.picture
        )
    }

    override fun mapToEntity(domainModel: User): UserEntity {
        return UserEntity(
            uid = domainModel.uid,
            firstName = domainModel.firstName,
            lastName = domainModel.lastName,
            email = domainModel.email,
            picture = domainModel.picture
        )
    }
}