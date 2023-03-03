package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model

data class LatestListData(
    val latest: List<LatestData>
)

data class LatestData(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)