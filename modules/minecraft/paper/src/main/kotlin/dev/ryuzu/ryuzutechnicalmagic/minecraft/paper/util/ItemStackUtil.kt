package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item.IItemProvider
import org.bukkit.inventory.ItemStack
import org.koin.core.component.KoinComponent

object ItemStackUtil : KoinComponent {
    private val itemProviders: List<IItemProvider> = getKoin().getAll<IItemProvider>().sortedBy { it.priority }

    fun getItemStack(item: Item): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(item) }
            ?: throw IllegalArgumentException("Item not found: ${item.id}")

    fun getItemStack(id: String): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(id) }
            ?: throw IllegalArgumentException("Item not found: $id")

    fun getId(itemStack: ItemStack): String =
        itemProviders.firstNotNullOfOrNull { it.getId(itemStack) }
            ?: throw IllegalArgumentException("Item not found: ${itemStack.type}")

    fun getItem(itemStack: ItemStack): Item = Item(
        dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ItemStackUtil.getId(
            itemStack
        ), itemStack.amount)
}