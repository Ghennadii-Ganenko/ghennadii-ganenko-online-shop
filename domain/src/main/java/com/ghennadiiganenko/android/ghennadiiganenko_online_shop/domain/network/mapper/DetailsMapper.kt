package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.DetailsData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.DetailsEntity

class DetailsMapper: IMapper<DetailsData, DetailsEntity> {
    override fun map(input: DetailsData): DetailsEntity = DetailsEntity(
        colors = input.colors,
        description = input.description,
        name = input.name,
        price = input.price,
        number_of_reviews = input.number_of_reviews,
        image_urls = input.image_urls,
        rating = input.rating
    )
}