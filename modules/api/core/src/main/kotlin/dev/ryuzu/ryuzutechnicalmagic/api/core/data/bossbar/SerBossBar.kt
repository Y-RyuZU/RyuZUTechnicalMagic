package dev.ryuzu.ryuzutechnicalmagic.api.core.data.bossbar

import kotlinx.serialization.Serializable

@Serializable
data class SerBossBar(
    val titles: List<String>,
    val color: String,
    val style: String
)