package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

data class PlayerPickUpEvent(
    override var player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer,
    override var item: Item,
    override var itemEntity: IEntity,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerPickUpEvent, ICancelableEvent by eventProps