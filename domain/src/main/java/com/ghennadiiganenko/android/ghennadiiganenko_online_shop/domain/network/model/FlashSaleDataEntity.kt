package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model

data class FlashSaleDataEntity (
    val flash_sale: List<FlashSaleEntity>
)

data class FlashSaleEntity (
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
    )

