package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect

data class StatusEffectState(
    val id: StatusEffectId,
    var duration: Int,
    var level: Int,
    val startedAt: Long = System.currentTimeMillis(),
) {
    fun isExpired(): Boolean =
        getRemainingTick() <= 0

    fun getRemainingTick(): Long =
        (((duration * 50L) + startedAt) - System.currentTimeMillis()) / 50L

    fun getRemainingSecond(): Long =
        getRemainingTick() / 20L

    fun getRemainingSecondFirstDecimal(): String =
        String.format("%.1f", getRemainingTick() / 20.0)
}
