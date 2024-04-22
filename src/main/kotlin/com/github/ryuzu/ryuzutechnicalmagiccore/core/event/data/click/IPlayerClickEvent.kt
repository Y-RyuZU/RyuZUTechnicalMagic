package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.INullableItemEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent

interface IPlayerClickEvent : IPlayerEvent, INullableItemEvent {
    val offHand: Boolean
}