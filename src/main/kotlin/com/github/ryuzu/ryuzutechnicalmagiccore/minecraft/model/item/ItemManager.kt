package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([IItemManager::class])
class ItemManager : IItemManager, KoinComponent {
    private val itemProviders: List<IItemProvider> = getKoin().getAll<IItemProvider>().sortedBy { it.priority }

    override fun getItemStack(item: Item): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(item) } ?:
        throw IllegalArgumentException("Item not found: ${item.id}")

    override fun getItemStack(id: String): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(id) } ?:
        throw IllegalArgumentException("Item not found: $id")

    override fun getId(itemStack: ItemStack): String =
        itemProviders.firstNotNullOfOrNull { it.getId(itemStack) } ?:
        throw IllegalArgumentException("Item not found: ${itemStack.type}")

    override fun getItem(itemStack: ItemStack): Item = Item(getId(itemStack), itemStack.amount)

    override fun giveItem(item: Item, players: Set<IPlayer>) {
        players.forEach {
            it.toPlayer().inventory.addItem(getItemStack(item))
        }
    }

    override fun giveItem(id: String, players: Set<IPlayer>) {
        players.forEach {
            it.toPlayer().inventory.addItem(getItemStack(id))
        }
    }

    override fun removeItem(item: Item, players: Set<IPlayer>) {
        players.forEach {
            it.toPlayer().inventory.removeItem(getItemStack(item))
        }
    }

    override fun removeItem(id: String, players: Set<IPlayer>) {
        players.forEach {
            it.toPlayer().inventory.remove(getItemStack(id))
        }
    }

    override fun hasEnoughSpace(item: Item, player: IPlayer): Boolean =
        player.toPlayer().inventory.firstEmpty() != -1
}