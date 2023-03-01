package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.Latest
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestDataEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestEntity

class LatestMapper : IMapper<LatestData?, LatestDataEntity?> {
    override fun map(input: LatestData?): LatestDataEntity? = input?.latest?.map { mapSingle(it) }?.let {
        LatestDataEntity(
        latest = it
    )
    }

    private fun mapSingle(input: Latest): LatestEntity = LatestEntity(
        category = input.category,
        image_url = input.image_url,
        name = input.name,
        price = input.price
    )
}