package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

data class PlayerLeftClickAirEvent(
    override var player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer,
    override var item: Item?,
    override val offHand: Boolean,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.IPlayerLeftClickEvent, IPlayerClickAirEvent, ICancelableEvent by eventProps