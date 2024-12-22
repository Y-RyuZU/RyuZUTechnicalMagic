package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.ConfiguredEffect

data class SerLevelParameter(
    val effect: ConfiguredEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, SerNormaParameter>,
)
