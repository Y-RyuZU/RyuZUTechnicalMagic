package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredColor
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredIntVector

data class ConfiguredTransitionColorParticle(
    override val id: String,
    override val count: Int,
    override val extra: Float,
    override val offset: ConfiguredDoubleVector,
    override val delay: Int,
    val color: ConfiguredColor,
    val size: Float,
    val transitionColor: ConfiguredColor
) : IConfiguredParticle
