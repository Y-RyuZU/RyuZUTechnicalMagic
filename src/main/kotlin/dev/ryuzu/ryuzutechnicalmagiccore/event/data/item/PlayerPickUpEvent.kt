package dev.ryuzu.ryuzutechnicalmagiccore.event.data.item

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

data class PlayerPickUpEvent(
    override var player: IPlayer,
    override var item: Item,
    override var itemEntity: IEntity,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerPickUpEvent, ICancelableEvent by eventProps