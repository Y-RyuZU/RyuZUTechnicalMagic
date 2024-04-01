package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.scheduler.SimpleSchedulerImpl
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf


@Single
class SimpleSchedulerFactory : KoinComponent {
    fun createScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): ISimpleScheduler =
        get { parametersOf(updatePeriod) }
}