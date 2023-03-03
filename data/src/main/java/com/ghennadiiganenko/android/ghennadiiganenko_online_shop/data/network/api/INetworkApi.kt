package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.api

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.DetailsData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSaleListData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestListData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.WordsData
import retrofit2.Response
import retrofit2.http.GET

interface INetworkApi {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): Response<LatestListData>

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): Response<FlashSaleListData>

    @GET("f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getDetails(): Response<DetailsData>

    @GET("4c9cd822-9479-4509-803d-63197e5a9e19")
    suspend fun getWords(): Response<WordsData>
}