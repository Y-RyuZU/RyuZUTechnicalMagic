package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)