package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.utils

interface IEntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}