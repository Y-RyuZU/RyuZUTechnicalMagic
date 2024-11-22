package dev.ryuzu.ryuzutechnicalmagiccore.event.data

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IPlayerEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

data class PlayerPortalReadyEvent(
    override val player: IPlayer,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerEvent, ICancelableEvent by eventProps