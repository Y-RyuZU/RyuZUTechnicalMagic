package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import java.util.*

class EntityDeathEvent(
    eventProps: IEntityDamageEvent
) : IEntityDeathEvent, IEntityDamageEvent by eventProps