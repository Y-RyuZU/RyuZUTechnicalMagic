package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredDoubleVector

data class ConfiguredBlockParticle(
    override val id: String,
    override val count: Int,
    override val extra: Float,
    override val offset: ConfiguredDoubleVector,
    override val receiver: ParticleReceiver,
    override val delay: Int,
    val block: String
) : IConfiguredParticle
