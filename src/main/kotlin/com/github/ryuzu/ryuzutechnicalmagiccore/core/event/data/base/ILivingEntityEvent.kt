package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity


interface ILivingEntityEvent : IEntityEvent {
    val livingEntity: ILivingEntity
}