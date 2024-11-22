package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.ILivingEntity

data class EntityDamageEvent(
    override var livingEntity: ILivingEntity,
    override var damage: Double,
    override var entity: IEntity = livingEntity,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDamageEvent, ICancelableEvent by eventProps