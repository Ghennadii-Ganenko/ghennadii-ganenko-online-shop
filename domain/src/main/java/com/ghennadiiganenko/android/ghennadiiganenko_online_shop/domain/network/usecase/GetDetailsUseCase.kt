package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.DetailsRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.DetailsMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.DetailsEntity

class GetDetailsUseCase(
    private val detailsRepository: DetailsRepository,
    private val detailsMapper: DetailsMapper
) {
    suspend operator fun invoke(): DetailsEntity? = detailsRepository.getDetailsList()
        ?.let { detailsMapper.map(it) }
}