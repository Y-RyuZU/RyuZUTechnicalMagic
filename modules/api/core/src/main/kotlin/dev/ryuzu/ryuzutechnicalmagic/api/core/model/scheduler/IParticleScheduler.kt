package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.IParticleSetData
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.IConfiguredParticleSet

interface IParticleScheduler : ISimpleScheduler {
    override fun schedule(tasks: Set<TaskUnit>): IParticleScheduler
    override fun schedule(vararg tasks: TaskUnit): IParticleScheduler = schedule(tasks.toSet())
    fun promise(task: IParticleScheduler): IParticleScheduler

    override fun schedule(
        delay: Long,
        period: Long,
        condition: (Long) -> Boolean,
        task: (ISimpleScheduler, Long) -> Unit
    ): IParticleScheduler =
        schedule(TaskUnit(delay, period, condition, task))

    override fun whileSchedule(
        condition: (Long) -> Boolean,
        task: (ISimpleScheduler, Long) -> Unit
    ): IParticleScheduler =
        schedule(0, Long.MAX_VALUE, condition, task)

    override fun end(task: () -> Unit): IParticleScheduler
    override fun finally(task: (Boolean) -> Unit): IParticleScheduler

    override fun runSync(alwaysTimer: Boolean): IParticleScheduler
    override fun runAsync(alwaysTimer: Boolean): IParticleScheduler

    fun set(configuredSet: IConfiguredParticleSet, data: IParticleSetData)
    fun getData(configuredSet: IConfiguredParticleSet, index: Int): IParticleSetData
}