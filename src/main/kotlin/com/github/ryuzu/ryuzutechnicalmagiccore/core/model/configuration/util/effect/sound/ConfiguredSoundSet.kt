package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.sound

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.particle.set.Receiver

data class ConfiguredSoundSet(
    val category: String = "MASTER",
    val listenerOnly: Boolean = false,
    val receiver: Receiver = Receiver.ALL,
    val sounds: Set<ConfiguredSound> = emptySet()
)
