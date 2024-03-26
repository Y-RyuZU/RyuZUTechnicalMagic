package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.block.IBlockService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.display.ITextDisplayService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.*
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@Single
class GameManager : IGameManager {
    private val structureService: IStructureService by inject()
    private val blockService: IBlockService by inject()
    private val textDisplayService: ITextDisplayService by inject()

    private val entries: ConfiguredEntry by inject()
    private val services: Map<ConfiguredIntLocation, IEntryGameService> =
        entries.worlds.map { world ->
            entries.points.map { point ->
                structureService.read(world, entries.structure)
                blockService.setBlock(point.toLocation(world), entries.block)
                textDisplayService.displayText(entries.display, point.copy(y = point.y + 1).toLocation(world))
                ConfiguredIntLocation(world, point)
            }
        }.flatten().associateWith { get<IEntryGameService> { parametersOf(it) } }

    override fun isEntryGate(location: ConfiguredIntLocation): Boolean = services.containsKey(location)

    override fun isEntryPlayer(location: ConfiguredIntLocation, player: IPlayer): Boolean =
        services[location]?.isEntryPlayer(player)!!

    override fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: IPlayer): Boolean {
        val service = services[location]!!
        val isPlayerLimitReached = service.getMaximumPlayer() <= service.getEntryPlayerNumber()
        val isPlayerAlreadyEntered = service.isEntryPlayer(player)
        return !(isPlayerLimitReached && !isPlayerAlreadyEntered)
    }

    override fun entryPlayer(location: ConfiguredIntLocation, player: IPlayer) {
        services[location]?.entry(player)
    }

    override fun exitPlayer(location: ConfiguredIntLocation, player: IPlayer) {
        services[location]?.leave(player)
    }

    override fun getGameMode(location: ConfiguredIntLocation): GameMode {
        return services[location]?.gameMode!!
    }

    override fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode) {
        services[location]?.gameMode = gameMode
    }

    private fun createEntryGameService(location: ConfiguredIntLocation): IEntryGameService {

        return get<IEntryGameService> { parametersOf(location) }
    }
}