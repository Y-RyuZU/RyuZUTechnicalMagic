package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IAirableItemEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent

interface IPlayerClickEvent : IPlayerEvent, IAirableItemEvent {
    val offHand: Boolean
}