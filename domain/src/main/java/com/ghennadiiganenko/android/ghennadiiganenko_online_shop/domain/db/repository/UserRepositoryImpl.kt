package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.database.UserDatabase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity

class UserRepositoryImpl(private val userDatabase: UserDatabase) : IUserRepository {
    override suspend fun addUser(user: UserEntity) {
        userDatabase.userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDatabase.userDao.deleteUser(user = user)
    }

    override suspend fun updatePicture(picture: String, firstName: String) {
        userDatabase.userDao.update(picture = picture, firstName = firstName)
    }

    override suspend fun getAll(): List<UserEntity> {
        return userDatabase.userDao.getAll()
    }

    override suspend fun isRegistered(user: UserEntity): Boolean {
        return userDatabase.userDao.isRegistered(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email
        )
    }

    override suspend fun isNameRegistered(firstName: String): Boolean {
        return userDatabase.userDao.isNameRegistered(firstName = firstName)
    }

    override suspend fun getUser(firstName: String): UserEntity {
        return userDatabase.userDao.getUser(firstName = firstName)
    }
}