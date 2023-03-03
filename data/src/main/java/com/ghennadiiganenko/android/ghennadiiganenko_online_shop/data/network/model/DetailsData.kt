package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model

data class DetailsData(
    val colors: List<String>,
    val description: String,
    val image_urls: List<String>,
    val name: String,
    val number_of_reviews: Int,
    val price: Int,
    val rating: Double
)