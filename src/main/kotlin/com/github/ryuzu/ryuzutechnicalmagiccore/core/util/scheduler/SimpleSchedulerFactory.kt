package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf


@Single
class SimpleSchedulerFactory : KoinComponent {
    fun createScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): ISimpleScheduler =
        get { parametersOf(updatePeriod) }

    fun createParticleScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): IParticleScheduler =
        get { parametersOf(createScheduler(updatePeriod), updatePeriod) }
}