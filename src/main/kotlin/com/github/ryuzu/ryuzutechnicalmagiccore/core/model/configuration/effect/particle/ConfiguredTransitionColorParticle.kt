package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredColor
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredScalableColor

data class ConfiguredTransitionColorParticle(
    override val id: String,
    override val count: Int,
    override val extra: Double,
    override val offset: ConfiguredDoubleVector,
    override val delay: Long,
    val fromColor: ConfiguredScalableColor,
    val toColor: ConfiguredColor,
    val size: Float,
) : IConfiguredParticle
