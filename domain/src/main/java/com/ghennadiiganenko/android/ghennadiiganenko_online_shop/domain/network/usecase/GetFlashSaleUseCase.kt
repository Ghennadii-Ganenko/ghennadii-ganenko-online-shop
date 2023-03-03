package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.FlashSaleRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.FlashSaleMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleListEntity

class GetFlashSaleUseCase(
    private val flashSaleRepository: FlashSaleRepository,
    private val flashSaleMapper: FlashSaleMapper
) {
    suspend operator fun invoke(): FlashSaleListEntity? = flashSaleMapper.map(flashSaleRepository.getFlashSaleList())
}