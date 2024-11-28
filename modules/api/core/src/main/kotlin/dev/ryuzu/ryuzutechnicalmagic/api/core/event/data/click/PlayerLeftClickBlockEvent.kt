package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

data class PlayerLeftClickBlockEvent(
    override var player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer,
    override var item: Item?,
    override val offHand: Boolean,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: IEntity = player,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.IPlayerLeftClickEvent, IPlayerClickBlockEvent, ICancelableEvent by eventProps