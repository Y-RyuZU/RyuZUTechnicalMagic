package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.general

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect

data class ConfiguredLevelParameter(
    val effect: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, ConfiguredNormaParameter>,
)
