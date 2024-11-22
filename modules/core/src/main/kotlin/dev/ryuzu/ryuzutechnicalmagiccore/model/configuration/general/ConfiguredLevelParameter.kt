package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredLevelParameter(
    val effect: ConfiguredEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, ConfiguredNormaParameter>,
)
