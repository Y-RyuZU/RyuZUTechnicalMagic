package dev.ryuzu.ryuzutechnicalmagiccore.model.game.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IDamageHistoryService {
    fun add(event: IEntityDamageEvent)
    fun removeOldHistories(player: IPlayer)
    fun removeAllPlayerOldHistories()
}