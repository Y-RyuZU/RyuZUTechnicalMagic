package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry.ConfiguredEntry
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.block.IBlockAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui.GuiType
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@Single([IGameManagerService::class], true)
class GameManagerServiceImpl : IGameManagerService {
    private val structureService: IStructureService by inject()
    private val blockService: IBlockAdapter by inject()

    private val entries: ConfiguredEntry by inject()
    private val services: Map<ConfiguredIntLocation, IEntryGameService> =
        entries.worlds.map { world ->
            structureService.read(world, entries.structure)
            entries.points.map { point ->
                blockService.setBlock(point.toLocation(world), entries.block)
                entries.effect.displays["EntryGateText"]?.forEach {
                    it.displays.forEach { display ->
                        display.spawn(point.copy(y = point.y + 1).toLocation(world).toDoubleLocation())
                    }
                }
                ConfiguredIntLocation(world, point)
            }
        }.flatten().associateWith { get<IEntryGameService> { parametersOf(it) } }


    override fun isEntryGate(location: ConfiguredIntLocation): Boolean = services.containsKey(location)

    override fun isEntryPlayer(location: ConfiguredIntLocation, player: IPlayer): Boolean =
        services[location]!!.isEntryPlayer(player)

    override fun hasEnoughEntrySpace(location: ConfiguredIntLocation, player: IPlayer): Boolean {
        val service = services[location]!!
        val isPlayerLimitReached = service.getMaximumPlayer() <= service.getEntryPlayerNumber()
        val isPlayerAlreadyEntered = service.isEntryPlayer(player)
        return !(isPlayerLimitReached && !isPlayerAlreadyEntered)
    }

    override fun entryPlayer(location: ConfiguredIntLocation, player: IPlayer) {
        services[location]!!.entry(player)
    }

    override fun exitPlayer(location: ConfiguredIntLocation, player: IPlayer) {
        services[location]!!.leave(player)
    }

    override fun getGameMode(location: ConfiguredIntLocation): GameMode {
        return services[location]!!.gameMode
    }

    override fun changeGameMode(location: ConfiguredIntLocation, gameMode: GameMode) {
        services[location]!!.gameMode = gameMode
    }

    override fun openEntryGui(location: ConfiguredIntLocation, player: IPlayer) {
        val changeGameModeActions: Map<GuiAction, () -> Unit> = mapOf(
            GameMode.CarryTnt.getGuiAction() to { changeGameMode(location, GameMode.CarryTnt) },
            GameMode.CaptureWool.getGuiAction() to { changeGameMode(location, GameMode.CaptureWool) },
        )

        val entryActions: Map<GuiAction, () -> Unit> = mapOf(
            GuiAction.OPEN_GUI_CHANGE_GAME_MODE to { player.openGui(GuiType.CHANGE_GAME_MODE_GUI, changeGameModeActions) }
        )
        player.openGui(GuiType.ENTRY_GUI, entryActions)
    }
}