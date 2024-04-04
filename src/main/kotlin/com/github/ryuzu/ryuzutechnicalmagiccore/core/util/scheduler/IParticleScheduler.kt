package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.IConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData

interface IParticleScheduler : ISimpleScheduler {
    fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData)
    fun get(configuredSet: IConfiguredParticleSet): IParticleSetData
}