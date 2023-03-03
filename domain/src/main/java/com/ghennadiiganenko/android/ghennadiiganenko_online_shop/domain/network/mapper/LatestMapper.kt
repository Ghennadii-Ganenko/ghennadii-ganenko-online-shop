package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.LatestListData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestListEntity

class LatestMapper : IMapper<LatestListData?, LatestListEntity?> {
    override fun map(input: LatestListData?): LatestListEntity? = input?.latest?.map { mapSingle(it) }?.let {
        LatestListEntity(
        latest = it
    )
    }

    private fun mapSingle(input: LatestData): LatestEntity = LatestEntity(
        category = input.category,
        image_url = input.image_url,
        name = input.name,
        price = input.price
    )
}