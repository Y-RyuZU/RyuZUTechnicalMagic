package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.AbstractEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IGameManager
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.gui.GuiType
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

@Factory([IEntryGameService::class])
class EntryGameServiceImpl(@InjectedParam location: ConfiguredIntLocation): AbstractEntryGameService(location), IEventHandler {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val gameManager: IGameManager by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler
    fun onInteractBlock(event: PlayerRightClickBlockEvent) {
        if(event.offHand) return
        if (!gameManager.isEntryGate(event.location)) return

        val player = event.player
        if (player.isSneaking()) {
            val changeGameModeActions: Map<GuiAction, () -> Unit> = mapOf(
                GameMode.CarryTnt.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CarryTnt) },
                GameMode.CaptureWool.getGuiAction() to { gameManager.changeGameMode(location, GameMode.CaptureWool) },
            )
            val changeGameModeGui: ChestGui = get { parametersOf(GuiType.CHANGE_GAME_MODE_GUI, changeGameModeActions) }

            val entryActions: Map<GuiAction, () -> Unit> = mapOf(
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