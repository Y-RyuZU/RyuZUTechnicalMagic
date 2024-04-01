package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import java.util.*

class EntityDeathEvent(
    override var entity: UUID,
    override var lastDamage: Double,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDeathEvent, ICancelableEvent by eventProps