package dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

interface IEntityDeathByEntityEvent : IEntityDeathEvent {
    val killerEntity: ILivingEntity
}