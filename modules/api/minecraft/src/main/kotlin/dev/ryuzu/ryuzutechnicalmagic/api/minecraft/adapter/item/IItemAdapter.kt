package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.item

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

interface IItemAdapter {
    fun giveItem(item: Item, vararg players: IPlayer)

    fun giveItem(id: String, vararg players: IPlayer)

    fun removeItem(item: Item, vararg players: IPlayer)

    fun removeItem(id: String, vararg players: IPlayer)

    fun hasEnoughSpace(item: Item, player: IPlayer): Boolean
}