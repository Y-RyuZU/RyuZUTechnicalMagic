package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredIntVector

data class ConfiguredColorParticle(
    override val id: String,
    override val count: Int,
    override val extra: Float,
    override val offset: ConfiguredDoubleVector,
    override val delay: Int,
    val color: ConfiguredIntVector,
    val size: Float
) : IConfiguredParticle
