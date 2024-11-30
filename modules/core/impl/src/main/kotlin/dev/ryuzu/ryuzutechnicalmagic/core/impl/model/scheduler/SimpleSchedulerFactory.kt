package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf


@Single
class SimpleSchedulerFactory : ISchedulerFactory, KoinComponent {
    override fun createSimpleScheduler(updatePeriod: UpdatePeriod): ISimpleScheduler =
        get { parametersOf(updatePeriod) }

    override fun createParticleScheduler(updatePeriod: UpdatePeriod): IParticleScheduler =
        get { parametersOf(createSimpleScheduler(updatePeriod), updatePeriod) }
}