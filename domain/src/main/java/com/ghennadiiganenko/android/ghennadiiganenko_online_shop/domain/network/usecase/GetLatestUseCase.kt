package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.LatestRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.LatestMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestListEntity

class GetLatestUseCase(
    private val latestRepository: LatestRepository,
    private val latestMapper: LatestMapper
) {
    suspend operator fun invoke(): LatestListEntity? = latestMapper.map(latestRepository.getLatestList())
}