package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ILivingEntityEvent

interface IEntityDamageEvent : ILivingEntityEvent, ICancelableEvent {
    var damage: Double
}