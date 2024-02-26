package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredIntVector

interface IConfiguredColorParticle: IConfiguredParticle {
    val color: ConfiguredIntVector
    val size: Float
}