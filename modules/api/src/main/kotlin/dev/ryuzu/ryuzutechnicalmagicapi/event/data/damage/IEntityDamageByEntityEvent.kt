package dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

interface IEntityDamageByEntityEvent : IEntityDamageEvent {
    val damagerEntity: ILivingEntity
}