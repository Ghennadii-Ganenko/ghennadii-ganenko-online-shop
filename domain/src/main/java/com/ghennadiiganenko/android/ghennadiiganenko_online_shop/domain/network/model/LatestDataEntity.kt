package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model

data class LatestDataEntity(
    val latest: List<LatestEntity>
)

data class LatestEntity(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)
