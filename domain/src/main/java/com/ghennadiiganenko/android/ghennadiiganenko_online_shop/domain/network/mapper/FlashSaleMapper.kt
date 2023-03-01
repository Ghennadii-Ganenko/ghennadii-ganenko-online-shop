package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSale
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.FlashSaleData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleDataEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleEntity

class FlashSaleMapper: IMapper<FlashSaleData?, FlashSaleDataEntity?> {
    override fun map(input: FlashSaleData?): FlashSaleDataEntity? = input?.flash_sale?.map { mapSingle(it) }?.let {
        FlashSaleDataEntity(
            flash_sale = it
        )
    }

    private fun mapSingle(input: FlashSale): FlashSaleEntity = FlashSaleEntity(
        category = input.category,
        image_url = input.image_url,
        name = input.name,
        price = input.price,
        discount = input.discount
    )
}