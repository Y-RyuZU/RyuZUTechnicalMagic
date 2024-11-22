package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.entry

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)