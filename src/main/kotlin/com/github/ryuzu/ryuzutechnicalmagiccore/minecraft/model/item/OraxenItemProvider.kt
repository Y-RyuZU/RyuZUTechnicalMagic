package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import io.th0rgal.oraxen.api.OraxenItems
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single

@Single([IItemProvider::class])
class OraxenItemProvider : IItemProvider {
    override fun getItemStack(itemId: String): ItemStack {
        return OraxenItems.getItemById(itemId).build() ?: throw IllegalArgumentException("Item with id $itemId does not exist")
    }

    override fun getId(itemStack: ItemStack): String? {
        return OraxenItems.getIdByItem(itemStack)
    }
}