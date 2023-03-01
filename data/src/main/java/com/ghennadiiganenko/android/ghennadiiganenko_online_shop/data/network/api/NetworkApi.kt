package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSaleData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestData
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): Response<LatestData>

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): Response<FlashSaleData>
}