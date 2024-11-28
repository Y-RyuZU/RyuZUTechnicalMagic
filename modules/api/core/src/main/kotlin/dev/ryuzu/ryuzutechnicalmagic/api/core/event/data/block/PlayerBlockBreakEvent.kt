package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.block

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity

data class PlayerBlockBreakEvent(
    override var player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerBlockBreakEvent, ICancelableEvent by eventProps