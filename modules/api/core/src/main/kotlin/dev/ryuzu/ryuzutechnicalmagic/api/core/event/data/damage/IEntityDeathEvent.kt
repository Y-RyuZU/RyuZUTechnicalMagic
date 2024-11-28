package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ILivingEntityEvent

interface IEntityDeathEvent : ILivingEntityEvent, ICancelableEvent {
    var lastDamage: Double
}