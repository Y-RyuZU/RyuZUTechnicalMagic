package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.damage

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.IEntityDamageEvent

data class DamageHistoryData(
    val eventParam: IEntityDamageEvent,
    val startedAt: Long = System.currentTimeMillis()
)
