package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.effect.particle.IParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet

interface IParticleScheduler : ISimpleScheduler {
    fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData)
    fun getData(configuredSet: IConfiguredParticleSet, index: Int): IParticleSetData
}