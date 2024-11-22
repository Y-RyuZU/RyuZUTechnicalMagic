package dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleSetData

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