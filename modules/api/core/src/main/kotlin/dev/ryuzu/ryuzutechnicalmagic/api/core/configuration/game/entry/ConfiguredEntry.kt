package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.ConfiguredEffect,
    val points: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector>,
    val worlds: Set<String>
)