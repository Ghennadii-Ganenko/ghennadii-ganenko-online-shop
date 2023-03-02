package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.repository

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity

interface IUserRepository {
    suspend fun addUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
    suspend fun updatePicture(picture: String, firstName: String)
    suspend fun getAll(): List<UserEntity>
    suspend fun isRegistered(user: UserEntity): Boolean
    suspend fun isNameRegistered(firstName: String): Boolean
    suspend fun getUser(firstName: String): UserEntity
}