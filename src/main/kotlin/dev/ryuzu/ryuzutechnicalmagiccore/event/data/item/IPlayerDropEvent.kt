package dev.ryuzu.ryuzutechnicalmagiccore.event.data.item

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IPlayerEvent
import java.util.*

interface IPlayerDropEvent : ICancelableEvent, IPlayerEvent, IItemEvent {
}