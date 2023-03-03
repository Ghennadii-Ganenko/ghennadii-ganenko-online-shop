package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.data.network.model.WordsData
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.WordsEntity

class WordsMapper: IMapper<WordsData, WordsEntity> {
    override fun map(input: WordsData): WordsEntity = WordsEntity(
        words = input.words
    )
}