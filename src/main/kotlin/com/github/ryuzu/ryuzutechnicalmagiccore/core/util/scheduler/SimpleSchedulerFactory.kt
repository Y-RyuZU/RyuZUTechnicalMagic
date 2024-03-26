package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.scheduler.SimpleSchedulerImpl
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get


@Single
class SimpleSchedulerFactory : KoinComponent {
    fun createScheduler(): ISimpleScheduler = get()
}