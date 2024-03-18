package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

data class ConfiguredParticleSet(
    val priority: Int,
    val amount: Int,
    val receiver: ParticleReceiver,
    val particles: Set<IConfiguredParticle>
)
