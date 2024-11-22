package  dev.ryuzu.ryuzutechnicalmagicapi.event.data

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IPlayerEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

data class PlayerPortalReadyEvent(
    override val player: IPlayer,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerEvent, ICancelableEvent by eventProps