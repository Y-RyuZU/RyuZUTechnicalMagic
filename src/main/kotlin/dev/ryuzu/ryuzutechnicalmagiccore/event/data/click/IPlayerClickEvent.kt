package dev.ryuzu.ryuzutechnicalmagiccore.event.data.click

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.INullableItemEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IPlayerEvent

interface IPlayerClickEvent : IPlayerEvent, INullableItemEvent {
    val offHand: Boolean
}