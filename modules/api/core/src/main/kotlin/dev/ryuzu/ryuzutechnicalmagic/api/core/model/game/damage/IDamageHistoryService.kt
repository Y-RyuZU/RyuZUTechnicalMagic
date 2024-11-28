package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.IEntityDamageEvent

interface IDamageHistoryService {
    fun add(event: IEntityDamageEvent)
    fun removeOldHistories(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun removeAllPlayerOldHistories()
}