package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.click

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import  dev.ryuzu.ryuzutechnicalmagicapi.model.storage.Item

data class PlayerLeftClickAirEvent(
    override var player: IPlayer,
    override var item: Item?,
    override val offHand: Boolean,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerLeftClickEvent, IPlayerClickAirEvent, ICancelableEvent by eventProps