package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IPlayerEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

interface IPlayerPickUpEvent : ICancelableEvent, IPlayerEvent, IItemEvent {
    var itemEntity: IEntity
}