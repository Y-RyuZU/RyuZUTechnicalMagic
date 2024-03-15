package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSound

data class ConfiguredParticleSet(
    val priority: Int,
    val amount: Int,
    val receiver: ParticleReceiver,
    val sounds: Set<IConfiguredParticle>
)
