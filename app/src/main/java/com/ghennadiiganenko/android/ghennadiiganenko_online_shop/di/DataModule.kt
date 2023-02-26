package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import android.app.Application
import androidx.room.Room
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.dao.UserDao
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.database.UserDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    fun provideDatabase(application: Application) : UserDatabase {
        return Room.databaseBuilder(application, UserDatabase::class.java, "user_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideUserDao(database: UserDatabase) : UserDao {
        return database.userDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideUserDao(get()) }
}