package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEntityEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ILivingEntityEvent
import java.util.*

interface IEntityDamageEvent : ILivingEntityEvent, ICancelableEvent {
    var damage: Double
}