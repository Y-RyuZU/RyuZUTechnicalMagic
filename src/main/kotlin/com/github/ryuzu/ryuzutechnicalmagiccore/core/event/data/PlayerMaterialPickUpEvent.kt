package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

class PlayerMaterialPickUpEvent(
    val player: IPlayer,
    var material: String,
    val itemEntity: UUID,
) : AbstractCancelableEvent()