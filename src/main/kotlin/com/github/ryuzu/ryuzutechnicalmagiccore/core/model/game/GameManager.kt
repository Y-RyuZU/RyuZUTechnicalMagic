package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.*
import org.koin.core.component.get

@Single
class GameManager : IGameManager {
    private val entries: ConfiguredEntry by inject()
    private val services: Map<ConfiguredIntLocation, IEntryGameService> =
        entries.worlds.map { world ->
            entries.points.map { point ->
                ConfiguredIntLocation(world, point)
            }
        }.flatten().associateWith { get<IEntryGameService>() }

    override fun isEntryGate(location: ConfiguredIntLocation): Boolean = services.containsKey(location)

    override fun isEntryPlayer(location: ConfiguredIntLocation, player: UUID): Boolean =
        services[location]?.isEntryPlayer(player)!!

    override fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: UUID): Boolean {
        val service = services[location]!!
        val isPlayerLimitReached = service.getMaximumPlayer() <= service.getEntryPlayerNumber()
        val isPlayerAlreadyEntered = service.isEntryPlayer(player)
        return !(isPlayerLimitReached && !isPlayerAlreadyEntered)
    }

    override fun entryPlayer(location: ConfiguredIntLocation, player: UUID) {
        services[location]?.entry(player)
    }

    override fun exitPlayer(location: ConfiguredIntLocation, player: UUID) {
        services[location]?.leave(player)
    }

    override fun getGameMode(location: ConfiguredIntLocation): GameMode {
        return services[location]?.gameMode!!
    }

    override fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode) {
        services[location]?.gameMode = gameMode
    }
}