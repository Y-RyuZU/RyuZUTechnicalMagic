package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

abstract class AbstractTeleportService : ITeleportService {
    override fun teleport(location: ConfiguredIntLocation, vararg players: IPlayer) {
        teleport(location, players.toSet())
    }

    override fun teleport(location: ConfiguredIntVector, vararg players: IPlayer) {
        teleport(location, players.toSet())
    }
}