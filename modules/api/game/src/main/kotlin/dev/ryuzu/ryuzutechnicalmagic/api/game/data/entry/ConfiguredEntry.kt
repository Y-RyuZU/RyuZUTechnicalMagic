package dev.ryuzu.ryuzutechnicalmagic.api.game.data.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect

data class ConfiguredEntry(
    val structure: String,
    val block: String,
    val effect: SerEffect,
    val points: Set<SerIntVector>,
    val worlds: Set<String>
)