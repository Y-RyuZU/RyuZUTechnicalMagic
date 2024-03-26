package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle

data class ConfiguredParticleSet(
    val priority: Int = 10,
//    val density: Int = 1,
    val vertical: Boolean = false,
    val receiver: ParticleReceiver = ParticleReceiver.ALL,
    val particles: Set<IConfiguredParticle>
)
