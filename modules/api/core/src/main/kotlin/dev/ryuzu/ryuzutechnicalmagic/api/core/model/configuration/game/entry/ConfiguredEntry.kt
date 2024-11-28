package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: ConfiguredEffect,
    val points: Set<ConfiguredIntVector>,
    val worlds: Set<String>
)