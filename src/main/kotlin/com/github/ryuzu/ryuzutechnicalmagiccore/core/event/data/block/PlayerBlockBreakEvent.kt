package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.IPlayerClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.IPlayerLeftClickEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

class PlayerBlockBreakEvent(
    override var player: IPlayer,
    override var location: ConfiguredIntLocation,
    override var block: String,
    override var entity: UUID = player.id,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerBlockBreakEvent, ICancelableEvent by eventProps