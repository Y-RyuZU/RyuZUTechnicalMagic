package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect


data class SerLevelParameter(
    val effect: SerEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, SerNormaParameter>,
)
