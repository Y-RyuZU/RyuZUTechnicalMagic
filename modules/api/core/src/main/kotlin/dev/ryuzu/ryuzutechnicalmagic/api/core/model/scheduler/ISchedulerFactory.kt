package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

interface ISchedulerFactory {
    fun createSimpleScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): ISimpleScheduler
    fun createParticleScheduler(updatePeriod: UpdatePeriod = UpdatePeriod.TICK): IParticleScheduler
}