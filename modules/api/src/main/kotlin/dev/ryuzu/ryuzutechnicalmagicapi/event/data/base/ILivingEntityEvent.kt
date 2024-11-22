package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity


interface ILivingEntityEvent : IEntityEvent {
    val livingEntity: ILivingEntity
}