package dev.ryuzu.ryuzutechnicalmagiccore.event.data.block

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

data class PlayerBlockBreakEvent(
    override var player: IPlayer,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerBlockBreakEvent, ICancelableEvent by eventProps