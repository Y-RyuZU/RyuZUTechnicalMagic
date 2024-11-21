package dev.ryuzu.ryuzutechnicalmagiccore.adapter.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.gui.GuiType

interface IPlayerAdapter {
    fun isSneaking(player: IPlayer): Boolean
    fun openGui(player: IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}