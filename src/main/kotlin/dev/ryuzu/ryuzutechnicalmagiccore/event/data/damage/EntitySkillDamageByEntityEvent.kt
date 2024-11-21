package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntitySkillDamageByEntityEvent(
    val eventProps: dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageByEntityEvent,
    override val skillSetId: String,
    override val skillId: String?,
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntitySkillDamageByEntityEvent, dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageByEntityEvent by eventProps