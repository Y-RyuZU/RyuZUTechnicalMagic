package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntityDamageEvent(
    override var livingEntity: ILivingEntity,
    override var damage: Double,
    override var entity: IEntity = livingEntity,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDamageEvent, ICancelableEvent by eventProps