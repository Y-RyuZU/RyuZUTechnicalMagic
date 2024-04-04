package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.IConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData
import org.koin.core.annotation.InjectedParam
import java.util.SortedSet

abstract class AbstractParticleScheduler(updatePeriod: UpdatePeriod) : IParticleScheduler, AbstractSimpleScheduler(updatePeriod) {
    private val particleSetDataMap: MutableMap<IConfiguredParticleSet, IParticleSetData> = mutableMapOf()

    override fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData) {
        particleSetDataMap[configuredSet] = data
    }
    override fun get(configuredSet: IConfiguredParticleSet): IParticleSetData = particleSetDataMap.getOrPut(configuredSet) { configuredSet.createParticleSetData() }
}