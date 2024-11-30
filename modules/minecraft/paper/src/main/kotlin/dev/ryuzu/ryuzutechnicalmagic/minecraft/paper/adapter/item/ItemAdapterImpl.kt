package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.item.IItemAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([IItemAdapter::class])
class ItemAdapterImpl : IItemAdapter, KoinComponent {
    private val itemProviders: List<IItemProvider> = getKoin().getAll<IItemProvider>().sortedBy { it.priority }

    override fun giveItem(item: Item, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.addItem(getItemStack(item))
        }
    }

    override fun giveItem(id: String, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.addItem(getItemStack(id))
        }
    }

    override fun removeItem(item: Item, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.removeItem(getItemStack(item))
        }
    }

    override fun removeItem(id: String, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.remove(getItemStack(id))
        }
    }

    override fun hasEnoughSpace(item: Item, player: IPlayer): Boolean =
        player.toPlayer().inventory.firstEmpty() != -1

    private fun getItemStack(item: Item): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(item) }
            ?: throw IllegalArgumentException("Item not found: ${item.id}")

    private fun getItemStack(id: String): ItemStack =
        itemProviders.firstNotNullOfOrNull { it.getItemStack(id) }
            ?: throw IllegalArgumentException("Item not found: $id")

    private fun getId(itemStack: ItemStack): String =
        itemProviders.firstNotNullOfOrNull { it.getId(itemStack) }
            ?: throw IllegalArgumentException("Item not found: ${itemStack.type}")

    private fun getItem(itemStack: ItemStack): Item =
        Item(
            getId(itemStack), itemStack.amount
        )
}