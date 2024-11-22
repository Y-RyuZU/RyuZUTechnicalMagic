package dev.ryuzu.ryuzutechnicalmagicapi.model.entity.effect

data class StatusEffectState(
    val id: StatusEffectId,
    var duration: Long,
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
