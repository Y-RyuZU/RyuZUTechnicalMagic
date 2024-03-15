package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredIntVector

/*
    TODO: Add sculk_charge, sculk_shriek, and sculk_sensor particles
 */
interface IConfiguredParticle {
    val id: String
    val count: Int
    val extra: Float
    val offset: ConfiguredDoubleVector
    val delay: Int
}