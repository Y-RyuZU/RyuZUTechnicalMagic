package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import java.util.*

class EntityDamageEvent(
    override var entity: UUID,
    override var damage: Double,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IEntityDeathEvent, ICancelableEvent by eventProps