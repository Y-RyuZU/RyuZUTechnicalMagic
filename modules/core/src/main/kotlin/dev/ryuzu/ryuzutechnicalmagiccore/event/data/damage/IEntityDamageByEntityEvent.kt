package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

interface IEntityDamageByEntityEvent : IEntityDamageEvent {
    val damagerEntity: ILivingEntity
}