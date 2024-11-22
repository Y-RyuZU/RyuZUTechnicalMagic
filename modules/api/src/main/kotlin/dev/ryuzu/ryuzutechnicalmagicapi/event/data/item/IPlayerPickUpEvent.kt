package dev.ryuzu.ryuzutechnicalmagicapi.event.data.item

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IPlayerEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity

interface IPlayerPickUpEvent : ICancelableEvent, IPlayerEvent, IItemEvent {
    var itemEntity: IEntity
}