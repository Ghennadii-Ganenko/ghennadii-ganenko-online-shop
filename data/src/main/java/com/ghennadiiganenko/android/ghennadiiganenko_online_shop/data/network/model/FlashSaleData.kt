package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model

data class FlashSaleData(
    val flash_sale: List<FlashSale>
)

data class FlashSale(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)