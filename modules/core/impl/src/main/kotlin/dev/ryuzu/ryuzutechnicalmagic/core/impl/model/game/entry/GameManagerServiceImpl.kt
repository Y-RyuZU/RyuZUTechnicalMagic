package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.entry.ConfiguredEntry
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry.IEntryGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry.IGameManagerService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.structure.IStructureService
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

@Single([IGameManagerService::class], true)
class GameManagerServiceImpl : IGameManagerService, KoinComponent {
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