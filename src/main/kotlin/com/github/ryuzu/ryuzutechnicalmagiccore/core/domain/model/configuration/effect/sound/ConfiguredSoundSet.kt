package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.sound

data class ConfiguredSoundSet(
    val name: String,
    val category: String,
    val sounds: List<ConfiguredSound>
)
