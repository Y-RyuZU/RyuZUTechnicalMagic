package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredColor
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredScalableColor

data class ConfiguredTransitionColorParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    override val delay: Long = 0,
    val fromColor: ConfiguredScalableColor,
    val toColor: ConfiguredColor,
    val size: Float,
) : IConfiguredParticle
