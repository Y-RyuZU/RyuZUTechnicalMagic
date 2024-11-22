package dev.ryuzu.ryuzutechnicalmagiccore.event.data.click

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

data class PlayerLeftClickAirEvent(
    override var player: IPlayer,
    override var item: Item?,
    override val offHand: Boolean,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerLeftClickEvent, IPlayerClickAirEvent, ICancelableEvent by eventProps