package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity

class EntityDeathEvent(
    override var livingEntity: ILivingEntity,
    override var lastDamage: Double,
    override var entity: IEntity = livingEntity,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDeathEvent, ICancelableEvent by eventProps