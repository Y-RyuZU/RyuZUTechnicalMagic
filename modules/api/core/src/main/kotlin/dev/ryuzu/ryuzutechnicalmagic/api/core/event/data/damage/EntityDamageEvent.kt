package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

data class EntityDamageEvent(
    override var livingEntity: ILivingEntity,
    override var damage: Double,
    override var entity: IEntity = livingEntity,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDamageEvent, ICancelableEvent by eventProps