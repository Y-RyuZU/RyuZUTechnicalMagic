package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import org.bukkit.inventory.ItemStack

interface IItemProvider {
    val priority: Int

    fun getItemStack(item: Item): ItemStack?
    fun getItemStack(id: String): ItemStack?
    fun getId(itemStack: ItemStack): String?
}