package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredIntVector

data class ConfiguredTransitionColorParticle(
    override val id: String,
    override val count: Int,
    override val extra: Float,
    override val offset: ConfiguredDoubleVector,
    override val receiver: ParticleReceiver,
    override val delay: Int,
    override val color: ConfiguredIntVector,
    override val size: Float,
    val transitionColor: ConfiguredIntVector
) : IConfiguredColorParticle
