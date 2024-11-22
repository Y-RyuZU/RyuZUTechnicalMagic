package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

interface IEntitySkillDeathByEntityEvent : IEntitySkillDeathEvent,
    dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathByEntityEvent