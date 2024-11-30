package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.INullableItemEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IPlayerEvent

interface IPlayerClickEvent : IPlayerEvent, INullableItemEvent {
    val offHand: Boolean
}