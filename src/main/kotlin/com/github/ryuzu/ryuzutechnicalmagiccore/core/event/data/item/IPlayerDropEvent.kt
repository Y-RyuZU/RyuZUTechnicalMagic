package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IItemEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent
import java.util.*

interface IPlayerDropEvent : ICancelableEvent, IPlayerEvent, IItemEvent {
}