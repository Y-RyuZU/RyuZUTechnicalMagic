package dev.ryuzu.ryuzutechnicalmagicapi.model.game.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage.IEntityDamageEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IDamageHistoryService {
    fun add(event: IEntityDamageEvent)
    fun removeOldHistories(player: IPlayer)
    fun removeAllPlayerOldHistories()
}