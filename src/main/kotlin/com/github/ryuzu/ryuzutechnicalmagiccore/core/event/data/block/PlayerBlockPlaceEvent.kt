package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

class PlayerBlockPlaceEvent(
    override var player: IPlayer,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: IEntity = player,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerBlockPlaceEvent, ICancelableEvent by eventProps