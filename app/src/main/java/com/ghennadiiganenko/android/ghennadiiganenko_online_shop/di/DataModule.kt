package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.di

import android.app.Application
import androidx.room.Room
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.dao.UserDao
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.db.model.database.UserDatabase
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.NetworkApi
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.datasource.RemoteDataSource
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.FlashSaleRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.LatestRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

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

    single { RemoteDataSource(get()) }

    single { provideProductsService(get()) }
    single { provideDefaultOkHttpClient() }

    single { LatestRepository(get()) }
    single { FlashSaleRepository(get()) }
}

fun provideProductsService(okHttpClient: OkHttpClient): NetworkApi = Retrofit.Builder()
    .baseUrl("https://run.mocky.io/v3/")
    .client(okHttpClient)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(NetworkApi::class.java)

fun provideDefaultOkHttpClient() = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .callTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()