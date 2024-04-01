package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect

data class ConfiguredLevelParameter(
    val effects: ConfiguredEffect,
    val successNormaCheckMessages: List<String>,
    val failNormaCheckMessages: List<String>,
    val selectStarNormaMessage: String,
    val selectKillNormaMessage: String,
    val normaParameter: Map<Int, ConfiguredNormaParameter>,
)
