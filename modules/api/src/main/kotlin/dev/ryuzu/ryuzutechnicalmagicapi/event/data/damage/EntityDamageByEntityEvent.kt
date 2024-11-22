package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.IEntitySkillCastEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

data class EntityDamageByEntityEvent(
    val eventProps: IEntityDamageEvent,
    override val damagerEntity: ILivingEntity,
) : IEntityDamageByEntityEvent, IEntityDamageEvent by eventProps