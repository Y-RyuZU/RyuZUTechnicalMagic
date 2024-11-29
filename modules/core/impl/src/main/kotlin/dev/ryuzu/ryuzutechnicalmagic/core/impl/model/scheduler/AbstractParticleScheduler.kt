package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.effect.particle.IParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

abstract class AbstractParticleScheduler(updatePeriod: UpdatePeriod) : IParticleScheduler,
    AbstractSimpleScheduler(updatePeriod) {
    private val particleSetDataMap: MutableMap<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet, MutableList<IParticleSetData>> = mutableMapOf()

    override fun set(configuredSet: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet, data: IParticleSetData) {
        TODO()
    }

    override fun getData(configuredSet: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet, index: Int): IParticleSetData =
        particleSetDataMap.computeIfAbsent(configuredSet){ mutableListOf() }
            .run{
                if (size <= index){
                    add(index, configuredSet.createParticleSetData())
                }
                get(index)
            }
}