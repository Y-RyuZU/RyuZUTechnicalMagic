package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.IGameManager
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.gui.GuiType
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class GameEntryListener : Listener, KoinComponent {
    private val gameManager: IGameManager by inject()

    @EventHandler
    fun onInteractBlock(event: PlayerInteractEvent) {
        val block = event.clickedBlock ?: return
        val location = block.location.toIntConfigured()
        if (!gameManager.isEntryGate(location)) return

        val player = event.player
        val playerId = player.uniqueId
        val rightClick = event.action == Action.RIGHT_CLICK_BLOCK
        if (rightClick) {
            if (gameManager.isEntryPlayer(location, playerId)) {
                gameManager.exitPlayer(location, playerId)
            } else if (gameManager.hasEnoughEntrySpace(location, playerId)) {
                gameManager.entryPlayer(location, playerId)
            }
        } else {
            val changeGameModeActions: HashMap<GuiAction, () -> Unit> = hashMapOf(
                GameMode.CARRY_TNT.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CARRY_TNT) },
                GameMode.CAPTURE_WOOL.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CAPTURE_WOOL) },
            )
            val changeGameModeGui: ChestGui = get { parametersOf(GuiType.CHANGE_GAME_MODE_GUI, changeGameModeActions) }

            val entryActions: HashMap<GuiAction, () -> Unit> = hashMapOf(
                GuiAction.OPEN_GUI_CHANGE_GAME_MODE to { changeGameModeGui.show(player) }
            )
            val entryGui: ChestGui = get { parametersOf(GuiType.ENTRY_GUI, entryActions) }
            entryGui.show(player)
        }
    }
}