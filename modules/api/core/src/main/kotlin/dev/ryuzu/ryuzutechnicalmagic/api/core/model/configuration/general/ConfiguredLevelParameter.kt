package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredLevelParameter(
    val effect: ConfiguredEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, ConfiguredNormaParameter>,
)
