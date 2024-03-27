package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.IGameManager
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.AbstractEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui.GuiType
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.koin.core.annotation.Factory
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

@Factory
class EntryGameServiceImpl(override val location: ConfiguredIntLocation): AbstractEntryGameService(location), IEventHandler {
    private val gameManager: IGameManager by inject()

    @EventHandler
    fun onInteractBlock(event: PlayerRightClickBlockEvent) {
        if (!gameManager.isEntryGate(event.location)) return

        val player = event.player
        if (player.isSneaking()) {
            val changeGameModeActions: HashMap<GuiAction, () -> Unit> = hashMapOf(
                GameMode.CarryTnt.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CarryTnt) },
                GameMode.CaptureWool.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CaptureWool) },
            )
            val changeGameModeGui: ChestGui = get { parametersOf(GuiType.CHANGE_GAME_MODE_GUI, changeGameModeActions) }

            val entryActions: HashMap<GuiAction, () -> Unit> = hashMapOf(
                GuiAction.OPEN_GUI_CHANGE_GAME_MODE to { changeGameModeGui.show(player.toPlayer()) }
            )
            val entryGui: ChestGui = get { parametersOf(GuiType.ENTRY_GUI, entryActions) }
            entryGui.show(player.toPlayer())
        } else {
            if (gameManager.isEntryPlayer(location, player)) {
                gameManager.exitPlayer(location, player)
            } else if (gameManager.hasEnoughEntrySpace(location, player)) {
                gameManager.entryPlayer(location, player)
            }
        }
    }
}