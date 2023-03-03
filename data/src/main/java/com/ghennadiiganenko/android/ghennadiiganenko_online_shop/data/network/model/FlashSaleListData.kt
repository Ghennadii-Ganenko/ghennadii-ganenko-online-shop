package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model

data class FlashSaleListData(
    val flash_sale: List<FlashSaleData>
)

data class FlashSaleData(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)