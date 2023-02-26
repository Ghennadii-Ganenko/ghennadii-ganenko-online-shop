package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.repository

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity

interface IUserRepository {
    suspend fun addUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
    suspend fun getAll(): List<UserEntity>
    suspend fun isRegistered(user: UserEntity): Boolean
    suspend fun getUser(firstName: String): UserEntity
}