package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler

class SimpleSchedulerFactory {
    companion object {
        fun createScheduler(): ISimpleScheduler {
            return SimpleScheduler()
        }
    }
}