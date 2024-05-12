package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import org.bukkit.inventory.ItemStack

interface IItemManager {
    fun getItemStack(item: Item): ItemStack
    fun getItemStack(id: String): ItemStack
    fun getId(itemStack: ItemStack): String
    fun getItem(itemStack: ItemStack): Item

    fun giveItem(item: Item, players: Set<IPlayer>)
    fun giveItem(item: Item, vararg players: IPlayer) = giveItem(item, players.toSet())

    fun giveItem(id: String, players: Set<IPlayer>)
    fun giveItem(id: String, vararg players: IPlayer) = giveItem(id, players.toSet())

    fun removeItem(item: Item, players: Set<IPlayer>)
    fun removeItem(item: Item, vararg players: IPlayer) = removeItem(item, players.toSet())

    fun removeItem(id: String, players: Set<IPlayer>)
    fun removeItem(id: String, vararg players: IPlayer) = removeItem(id, players.toSet())

    fun hasEnoughSpace(item: Item, player: IPlayer): Boolean
}