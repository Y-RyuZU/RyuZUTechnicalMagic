package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.block

data class BlockDamageData (
    val damage: Int,
    val startedAt: Long = System.currentTimeMillis()
)