package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter.entity

import com.github.ryuzu.ryuzutechnicalmagiccore.core.adapter.entity.IPlayerAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui.GuiType
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@Single([IPlayerAdapter::class], true)
class PlayerAdapterImpl : IPlayerAdapter, KoinComponent {
    override fun isSneaking(player: IPlayer): Boolean {
        return player.toPlayer().isSneaking
    }

    override fun openGui(player: IPlayer, gui: GuiType, actions: Map<GuiAction, () -> Unit>) {
        val changeGameModeGui: ChestGui = get { parametersOf(gui, actions) }
        changeGameModeGui.show(player.toPlayer())
    }
}