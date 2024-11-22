package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity


interface ILivingEntityEvent : IEntityEvent {
    val livingEntity: ILivingEntity
}