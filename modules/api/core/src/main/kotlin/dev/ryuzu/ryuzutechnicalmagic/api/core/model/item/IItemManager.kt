package dev.ryuzu.ryuzutechnicalmagic.api.core.model.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

interface IItemManager {
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