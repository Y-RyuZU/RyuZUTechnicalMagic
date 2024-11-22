package dev.ryuzu.ryuzutechnicalmagicapi.adapter.entity

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.gui.GuiType

interface IPlayerAdapter {
    fun isSneaking(player: IPlayer): Boolean
    fun openGui(player: IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}