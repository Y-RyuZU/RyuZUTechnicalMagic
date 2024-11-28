package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType

interface IPlayerAdapter {
    fun isSneaking(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun openGui(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}