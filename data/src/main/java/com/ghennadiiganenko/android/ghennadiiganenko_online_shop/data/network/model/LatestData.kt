package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model

data class LatestData(
    val latest: List<Latest>
)

data class Latest(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)