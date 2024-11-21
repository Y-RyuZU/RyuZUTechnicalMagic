package dev.ryuzu.ryuzutechnicalmagiccore.event.data.click

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

data class PlayerRightClickAirEvent(
    override var player: IPlayer,
    override var item: Item?,
    override val offHand: Boolean,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.click.IPlayerRightClickEvent,
    dev.ryuzu.ryuzutechnicalmagiccore.event.data.click.IPlayerClickAirEvent, ICancelableEvent by eventProps