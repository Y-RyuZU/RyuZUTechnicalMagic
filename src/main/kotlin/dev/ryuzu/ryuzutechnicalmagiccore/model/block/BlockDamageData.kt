package dev.ryuzu.ryuzutechnicalmagiccore.model.block

data class BlockDamageData (
    val damage: Int,
    val startedAt: Long = System.currentTimeMillis()
)