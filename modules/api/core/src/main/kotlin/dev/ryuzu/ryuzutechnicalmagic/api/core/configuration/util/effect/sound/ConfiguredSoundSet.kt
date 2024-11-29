package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.sound

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.Receiver

data class ConfiguredSoundSet(
    val category: String = "MASTER",
    val listenerOnly: Boolean = false,
    val receiver: Receiver = Receiver.ALL,
    val sounds: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.sound.ConfiguredSound> = emptySet()
)