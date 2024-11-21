package dev.ryuzu.ryuzutechnicalmagiccore.model.game.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDamageEvent

data class DamageHistoryData(
    val eventParam: IEntityDamageEvent,
    val startedAt: Long = System.currentTimeMillis()
)
