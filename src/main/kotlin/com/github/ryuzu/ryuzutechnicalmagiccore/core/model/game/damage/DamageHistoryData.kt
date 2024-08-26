package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.IEntityDamageEvent

data class DamageHistoryData(
    val eventParam: IEntityDamageEvent,
    val startedAt: Long = System.currentTimeMillis()
)
