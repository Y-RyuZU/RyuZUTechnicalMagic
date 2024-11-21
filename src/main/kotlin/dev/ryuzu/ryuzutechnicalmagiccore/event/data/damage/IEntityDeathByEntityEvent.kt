package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

interface IEntityDeathByEntityEvent : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent {
    val killerEntity: ILivingEntity
}