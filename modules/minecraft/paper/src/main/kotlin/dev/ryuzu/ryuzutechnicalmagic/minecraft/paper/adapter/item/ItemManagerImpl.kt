package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.item.IItemManager
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ItemStackUtil
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent

@Single([IItemManager::class])
class ItemManagerImpl : IItemManager, KoinComponent {
    override fun giveItem(item: Item, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.addItem(ItemStackUtil.getItemStack(item))
        }
    }

    override fun giveItem(id: String, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.addItem(ItemStackUtil.getItemStack(id))
        }
    }

    override fun removeItem(item: Item, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.removeItem(ItemStackUtil.getItemStack(item))
        }
    }

    override fun removeItem(id: String, vararg players: IPlayer) {
        players.forEach {
            it.toPlayer().inventory.remove(ItemStackUtil.getItemStack(id))
        }
    }

    override fun hasEnoughSpace(item: Item, player: IPlayer): Boolean =
        player.toPlayer().inventory.firstEmpty() != -1
}