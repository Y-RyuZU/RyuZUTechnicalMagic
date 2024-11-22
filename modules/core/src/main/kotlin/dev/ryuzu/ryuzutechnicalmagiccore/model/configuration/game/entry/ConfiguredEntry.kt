package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.entry

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)