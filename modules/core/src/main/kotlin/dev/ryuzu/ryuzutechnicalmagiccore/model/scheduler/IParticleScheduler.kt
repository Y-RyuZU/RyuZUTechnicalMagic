package dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleSetData

interface IParticleScheduler : ISimpleScheduler {
    fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData)
    fun getData(configuredSet: IConfiguredParticleSet, index: Int): IParticleSetData
}