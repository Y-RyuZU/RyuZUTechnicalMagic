package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

class PlayerItemPickUpEvent(
    val player: IPlayer,
    val item: String,
    val itemEntity: UUID,
) : AbstractCancelableEvent()