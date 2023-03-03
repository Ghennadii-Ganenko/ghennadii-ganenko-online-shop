package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSaleData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSaleListData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleListEntity

class FlashSaleMapper: IMapper<FlashSaleListData?, FlashSaleListEntity?> {
    override fun map(input: FlashSaleListData?): FlashSaleListEntity? = input?.flash_sale?.map { mapSingle(it) }?.let {
        FlashSaleListEntity(
            flash_sale = it
        )
    }

    private fun mapSingle(input: FlashSaleData): FlashSaleEntity = FlashSaleEntity(
        category = input.category,
        image_url = input.image_url,
        name = input.name,
        price = input.price,
        discount = input.discount
    )
}