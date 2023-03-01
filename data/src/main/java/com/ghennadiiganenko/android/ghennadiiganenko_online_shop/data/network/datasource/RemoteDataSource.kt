package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.datasource

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.BaseDataSource
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.NetworkApi

class RemoteDataSource  constructor(
    private val networkApi: NetworkApi,
): BaseDataSource() {

    suspend fun getLatest() = getResult { networkApi.getLatest() }

    suspend fun getFlashSale() = getResult { networkApi.getFlashSale() }
}