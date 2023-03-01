package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api

import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                return if (body != null) Result.success(body)
                else Result.emptySuccess()
            }
            val serverError = response.errorBody()?.string() ?: "${response.code()}: ${response.message()}"
            return error(serverError, response.code())
        } catch (e: Exception) {
            return error(e.message ?: e.toString(), null)
        }
    }

    private fun <T> error(message: String, statusCode: Int?): Result<T> {
        return Result.error(message, statusCode = statusCode)
    }
}