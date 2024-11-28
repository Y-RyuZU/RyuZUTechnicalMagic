package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity


interface ILivingEntityEvent : IEntityEvent {
    val livingEntity: ILivingEntity
}