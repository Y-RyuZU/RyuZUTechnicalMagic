package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IPlayerEvent

interface IPlayerDropEvent : ICancelableEvent, IPlayerEvent, IItemEvent