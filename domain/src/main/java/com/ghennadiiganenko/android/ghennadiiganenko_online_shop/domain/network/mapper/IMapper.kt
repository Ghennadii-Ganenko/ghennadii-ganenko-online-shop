package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.mapper

interface IMapper<I, O> {
    fun map(input: I): O
}