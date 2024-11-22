package dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.particle.IParticleSetData

interface IParticleScheduler : ISimpleScheduler {
    fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData)
    fun getData(configuredSet: IConfiguredParticleSet, index: Int): IParticleSetData
}