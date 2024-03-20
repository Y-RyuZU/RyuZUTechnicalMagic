package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredScalableColor

data class ConfiguredColorParticle(
    override val id: String,
    override val count: Int,
    override val extra: Double,
    override val offset: ConfiguredDoubleVector,
    override val delay: Long,
    val color: ConfiguredScalableColor,
    val size: Float
) : IConfiguredParticle
