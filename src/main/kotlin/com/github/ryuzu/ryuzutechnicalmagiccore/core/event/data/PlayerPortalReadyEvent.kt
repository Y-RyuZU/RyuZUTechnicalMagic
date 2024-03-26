package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

class PlayerPortalReadyEvent(
    val player: IPlayer,
) : AbstractCancelableEvent() {
}