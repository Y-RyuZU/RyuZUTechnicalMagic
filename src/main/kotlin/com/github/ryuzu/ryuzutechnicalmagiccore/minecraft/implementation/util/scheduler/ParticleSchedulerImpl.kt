package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.RyuZUTechnicalMagicCore
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.*
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory([IParticleScheduler::class])
class ParticleSchedulerImpl(@InjectedParam scheduler: ISimpleScheduler, @InjectedParam updatePeriod: UpdatePeriod) : AbstractParticleScheduler(updatePeriod), ISimpleScheduler by scheduler {

}