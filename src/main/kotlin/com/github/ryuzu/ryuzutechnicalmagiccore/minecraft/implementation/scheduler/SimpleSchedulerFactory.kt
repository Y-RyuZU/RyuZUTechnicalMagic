package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import org.koin.core.annotation.Single


@Single
class SimpleSchedulerFactory {
    fun createScheduler(): ISimpleScheduler {
        return SimpleScheduler()
    }
}