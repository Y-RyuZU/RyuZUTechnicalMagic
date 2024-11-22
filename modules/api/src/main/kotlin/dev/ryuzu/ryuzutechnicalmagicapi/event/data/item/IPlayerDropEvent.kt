package dev.ryuzu.ryuzutechnicalmagicapi.event.data.item

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IPlayerEvent
import java.util.*

interface IPlayerDropEvent : ICancelableEvent, IPlayerEvent, IItemEvent