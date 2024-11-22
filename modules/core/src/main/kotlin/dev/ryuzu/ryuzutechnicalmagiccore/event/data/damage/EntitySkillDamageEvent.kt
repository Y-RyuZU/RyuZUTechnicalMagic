package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntitySkillDamageEvent(
    val eventProps: dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageEvent,
    override val skillSetId: String,
    override val skillId: String?
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntitySkillDamageEvent, dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageEvent by eventProps