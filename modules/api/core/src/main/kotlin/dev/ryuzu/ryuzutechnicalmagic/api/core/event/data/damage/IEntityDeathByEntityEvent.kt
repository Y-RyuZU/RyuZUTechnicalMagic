package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

interface IEntityDeathByEntityEvent : IEntityDeathEvent {
    val killerEntity: ILivingEntity
}