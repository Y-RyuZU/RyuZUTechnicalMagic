package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity

class EntityDamageEvent(
    override var entity: IEntity,
    override var damage: Double,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDamageEvent, ICancelableEvent by eventProps