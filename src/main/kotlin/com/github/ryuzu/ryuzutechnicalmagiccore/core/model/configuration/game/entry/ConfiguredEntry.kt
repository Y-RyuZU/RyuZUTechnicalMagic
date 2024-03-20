package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect

data class ConfiguredEntry(
    val block: String,
    val display: String,
    val effects: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)