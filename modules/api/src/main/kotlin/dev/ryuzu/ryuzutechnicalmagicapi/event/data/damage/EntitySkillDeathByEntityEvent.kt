package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.IEntitySkillCastEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

data class EntitySkillDeathByEntityEvent(
    val eventProps: IEntityDeathByEntityEvent,
    override val skillSetId: String,
    override val skillId: String?,
) : IEntitySkillDeathByEntityEvent, IEntityDeathByEntityEvent by eventProps