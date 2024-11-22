package dev.ryuzu.ryuzutechnicalmagicapi.event.data.click

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.INullableItemEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IPlayerEvent

interface IPlayerClickEvent : IPlayerEvent, INullableItemEvent {
    val offHand: Boolean
}