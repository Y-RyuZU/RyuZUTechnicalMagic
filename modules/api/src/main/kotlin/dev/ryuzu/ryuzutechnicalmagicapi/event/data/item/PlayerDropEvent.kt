package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.item

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import  dev.ryuzu.ryuzutechnicalmagicapi.model.storage.Item

data class PlayerDropEvent(
    override var player: IPlayer,
    override var item: Item,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerDropEvent, ICancelableEvent by eventProps