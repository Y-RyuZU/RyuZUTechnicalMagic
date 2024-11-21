package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntityDeathByEntityEvent(
    val eventProps: dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent,
    override val killerEntity: ILivingEntity,
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathByEntityEvent, dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent by eventProps