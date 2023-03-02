package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.dao

import androidx.room.*
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("UPDATE user SET picture = :picture WHERE firstName = :firstName")
    fun update(picture: String, firstName: String)

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT EXISTS(SELECT * FROM user WHERE firstName = :firstName OR lastName = :lastName OR email = :email)")
    fun isRegistered(firstName: String, lastName: String, email: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM user WHERE firstName = :firstName)")
    fun isNameRegistered(firstName: String): Boolean

    @Query("SELECT * FROM user WHERE firstName = :firstName")
    fun getUser(firstName: String): UserEntity
}