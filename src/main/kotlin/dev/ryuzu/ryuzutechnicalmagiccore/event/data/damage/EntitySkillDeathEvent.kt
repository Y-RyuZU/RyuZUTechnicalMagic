package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntitySkillDeathEvent(
    val eventProps: dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent,
    override val skillSetId: String,
    override val skillId: String?
) : IEntitySkillDeathEvent, dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent by eventProps