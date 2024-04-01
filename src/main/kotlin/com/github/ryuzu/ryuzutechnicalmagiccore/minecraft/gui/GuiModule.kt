package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.ConfiguredGui
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui.GuiAction
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item.IItemProvider
import com.github.stefvanschie.inventoryframework.gui.GuiItem
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui
import com.github.stefvanschie.inventoryframework.pane.StaticPane
import com.github.stefvanschie.inventoryframework.pane.util.Slot
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Module
class GuiModule : KoinComponent {
    private val itemProvider: IItemProvider by inject()
    private val guis: Map<String, ConfiguredGui> by inject()

    @Factory
    fun entryGui(@InjectedParam type: GuiType, @InjectedParam actions: Map<GuiAction, () -> Unit>): ChestGui {
        require(guis.containsKey(type.toString())) { "Gui type $type is not found" }
        return createGui(guis[type.toString()]!!, actions)
    }

    private fun createGui(config: ConfiguredGui, action: Map<GuiAction, () -> Unit>): ChestGui {
        val gui = ChestGui(config.rows, config.name)
        val pane = StaticPane(0, 0, 9, 6)
        config.items.forEach { (slot, item) ->
            val itemStack = GuiItem(itemProvider.getItemStack(item.items.elementAt(0)))
            itemStack.setAction { _ -> action[item.action] }
            pane.addItem(itemStack, Slot.fromIndex(slot))
        }
        gui.addPane(pane)
        return gui
    }
}