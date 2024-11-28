package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.scheduler

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.*
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory([IParticleScheduler::class])
class ParticleSchedulerImpl(@InjectedParam scheduler: ISimpleScheduler, @InjectedParam updatePeriod: UpdatePeriod) : AbstractParticleScheduler(updatePeriod), ISimpleScheduler by scheduler {

}