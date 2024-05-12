package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.IPlayerDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IDamageHistoryService : KoinComponent {
    fun add(event: IPlayerDamageEvent)
    fun removeOldHistories(player: IPlayer)
    fun removeAllPlayerOldHistories()
}