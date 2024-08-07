package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.IConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleSetData

abstract class AbstractParticleScheduler(updatePeriod: UpdatePeriod) : IParticleScheduler,
    AbstractSimpleScheduler(updatePeriod) {
    private val particleSetDataMap: MutableMap<IConfiguredParticleSet, MutableList<IParticleSetData>> = mutableMapOf()

    override fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData) {
        TODO()
    }

    override fun getData(configuredSet: IConfiguredParticleSet, index: Int): IParticleSetData =
        particleSetDataMap.computeIfAbsent(configuredSet){ mutableListOf() }
            .run{
                if (size <= index){
                    add(index, configuredSet.createParticleSetData())
                }
                get(index)
            }
}