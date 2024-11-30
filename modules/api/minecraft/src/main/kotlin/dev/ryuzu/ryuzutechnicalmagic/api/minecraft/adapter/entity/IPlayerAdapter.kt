package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType

interface IPlayerAdapter {
    fun getName(player: IPlayer): String
    fun isSneaking(player: IPlayer): Boolean
    fun openGui(player: IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>)
    fun changeGameMode(gameMode: Int, player: IPlayer)
    fun changeGameMode(gameMode: Int, player: IPlayer, lock: Boolean)
    fun isLocked(player: IPlayer): Boolean

    fun sendTitle(messages: String?, subtitle: String?, vararg players: IPlayer)

    fun sendMessage(messages: List<String>, vararg players: IPlayer)
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, vararg players: IPlayer)
}