package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

/*
    TODO: Add sculk_charge, sculk_shriek, and sculk_sensor particles
 */
interface IConfiguredParticle {
    val id: String
    val count: Int
    val extra: Double
    val offset: ConfiguredDoubleVector
    val delay: Long
}