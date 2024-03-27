package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

class PlayerLeftClickBlockEvent(
    override var player: IPlayer,
    override var item: String?,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: UUID = player.id,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerLeftClickEvent, IPlayerClickBlockEvent, ICancelableEvent by eventProps