package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import org.bukkit.inventory.ItemStack

interface IItemProvider {
    val priority: Int

    fun getItemStack(item: Item): ItemStack?
    fun getItemStack(id: String): ItemStack?
    fun getId(itemStack: ItemStack): String?
}