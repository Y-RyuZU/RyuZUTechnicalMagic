package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import io.th0rgal.oraxen.api.OraxenItems
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single

@Single
class OraxenItemProvider : IItemProvider {
    override fun getItemStack(itemId: String): ItemStack {
        return OraxenItems.getItemById(itemId).build() ?: throw IllegalArgumentException("Item with id $itemId does not exist")
    }

    override fun getId(itemStack: ItemStack): String? {
        return OraxenItems.getIdByItem(itemStack)
    }
}