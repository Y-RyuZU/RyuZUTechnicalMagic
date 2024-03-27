package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.AbstractEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

class PlayerQuitEvent(
    override var player: IPlayer,
    override var entity: UUID = player.id,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerEvent, ICancelableEvent by eventProps