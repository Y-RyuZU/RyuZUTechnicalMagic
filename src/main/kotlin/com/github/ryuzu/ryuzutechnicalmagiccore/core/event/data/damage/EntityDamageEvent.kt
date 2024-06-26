package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity

class EntityDamageEvent(
    override var livingEntity: ILivingEntity,
    override var damage: Double,
    override var entity: IEntity = livingEntity,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDamageEvent, ICancelableEvent by eventProps