package com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui.GuiType

interface IPlayerAdapter {
    fun isSneaking(player: IPlayer): Boolean
    fun openGui(player: IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}