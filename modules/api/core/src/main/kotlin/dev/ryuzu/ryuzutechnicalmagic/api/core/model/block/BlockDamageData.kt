package dev.ryuzu.ryuzutechnicalmagic.api.core.model.block

data class BlockDamageData (
    val damage: Int,
    val startedAt: Long = System.currentTimeMillis()
)