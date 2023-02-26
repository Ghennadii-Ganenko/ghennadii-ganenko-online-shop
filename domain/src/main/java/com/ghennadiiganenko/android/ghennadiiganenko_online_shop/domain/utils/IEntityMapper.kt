package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.utils

interface IEntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}