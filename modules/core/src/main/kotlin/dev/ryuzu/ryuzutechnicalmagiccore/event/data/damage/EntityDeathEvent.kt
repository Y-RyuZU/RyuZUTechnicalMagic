package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntityDeathEvent(
    override var livingEntity: ILivingEntity,
    override var lastDamage: Double,
    override var entity: IEntity = livingEntity,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent, ICancelableEvent by eventProps