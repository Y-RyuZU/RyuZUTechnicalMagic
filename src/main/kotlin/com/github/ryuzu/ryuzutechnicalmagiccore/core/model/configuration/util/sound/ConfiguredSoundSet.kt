package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound

data class ConfiguredSoundSet(
    val category: String = "MASTER",
    val listenerOnly: Boolean = false,
    val sounds: Set<ConfiguredSound>
)
