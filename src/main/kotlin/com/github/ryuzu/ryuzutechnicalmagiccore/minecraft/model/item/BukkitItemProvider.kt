package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import io.th0rgal.oraxen.api.OraxenItems
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single

@Single([IItemProvider::class])
class BukkitItemProvider : IItemProvider {
    override fun getItemStack(item: Item): ItemStack? =
        runCatching { Material.valueOf(item.id) }.getOrNull()?.let { ItemStack(it, item.amount) }

    override fun getItemStack(id: String): ItemStack? =
        runCatching { Material.valueOf(id) }.getOrNull()?.let { ItemStack(it) }

    override fun getId(itemStack: ItemStack): String? =
        itemStack.type.name
}