package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.Result
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.datasource.RemoteDataSource
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestData

class LatestRepository(
    private val remoteDataSource: RemoteDataSource,
) {
    suspend fun getLatestList(): LatestData? {
        val result = remoteDataSource.getLatest()
        if (result.status == Result.Status.SUCCESS) {
            return result.data ?: return null
        }
        return null
    }
}