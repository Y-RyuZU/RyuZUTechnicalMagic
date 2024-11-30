package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import io.th0rgal.oraxen.api.OraxenItems
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single

@Single([IItemProvider::class])
class OraxenItemProvider : IItemProvider {
    override val priority: Int = 0
    override fun getItemStack(item: Item): ItemStack? =
        OraxenItems.getItemById(item.id)?.build()?.asQuantity(item.amount)

    override fun getItemStack(id: String): ItemStack? =
        OraxenItems.getItemById(id)?.build()

    override fun existsId(id: String): Boolean =
        OraxenItems.exists(id)

    override fun getId(itemStack: ItemStack): String? =
        OraxenItems.getIdByItem(itemStack)
}