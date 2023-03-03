package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.datasource

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.BaseDataSource
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api.INetworkApi

class RemoteDataSource  constructor(
    private val networkApi: INetworkApi,
): BaseDataSource() {

    suspend fun getLatest() = getResult { networkApi.getLatest() }

    suspend fun getFlashSale() = getResult { networkApi.getFlashSale() }

    suspend fun getDetails() = getResult { networkApi.getDetails() }

    suspend fun getWords() = getResult { networkApi.getWords() }
}