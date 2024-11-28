package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.IPlayerEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

data class PlayerQuitEvent(
    override val player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerEvent, ICancelableEvent by eventProps