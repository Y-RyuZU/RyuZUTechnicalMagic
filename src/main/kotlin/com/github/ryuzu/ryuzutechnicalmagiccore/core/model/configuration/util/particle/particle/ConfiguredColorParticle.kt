package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredScalableColor

data class ConfiguredColorParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    override val delay: Long = 0,
    val color: ConfiguredScalableColor,
    val size: Float
) : IConfiguredParticle
