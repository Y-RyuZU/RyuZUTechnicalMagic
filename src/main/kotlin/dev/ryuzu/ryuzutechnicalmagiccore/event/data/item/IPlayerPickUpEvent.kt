package dev.ryuzu.ryuzutechnicalmagiccore.event.data.item

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IItemEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IPlayerEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity

interface IPlayerPickUpEvent : ICancelableEvent, IPlayerEvent, IItemEvent {
    var itemEntity: IEntity
}