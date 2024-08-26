package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.IEntityDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IDamageHistoryService {
    fun add(event: IEntityDamageEvent)
    fun removeOldHistories(player: IPlayer)
    fun removeAllPlayerOldHistories()
}