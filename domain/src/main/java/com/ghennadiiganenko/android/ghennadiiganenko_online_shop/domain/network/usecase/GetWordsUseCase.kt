package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.usecase

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.repository.WordsRepository
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper.WordsMapper
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.WordsEntity

class GetWordsUseCase(
    private val wordsRepository: WordsRepository,
    private val wordsMapper: WordsMapper
) {
    suspend operator fun invoke(): WordsEntity? = wordsRepository.getWordsList()
        ?.let { wordsMapper.map(it) }
}