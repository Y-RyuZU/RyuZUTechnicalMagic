package dev.ryuzu.ryuzutechnicalmagicapi.core.model.scheduler

import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.UpdatePeriod

interface ISchedulerFactory {
    fun createScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): ISimpleScheduler
    fun createParticleScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): IParticleScheduler
}