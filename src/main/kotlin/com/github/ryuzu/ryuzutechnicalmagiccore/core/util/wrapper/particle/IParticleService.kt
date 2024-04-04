package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.IConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.OrthonormalBasis
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.IParticleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import org.koin.core.component.KoinComponent

interface IParticleService : KoinComponent {
    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        receivers: Set<IPlayer>
    ): Set<TaskUnit>

    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        vararg receivers: IPlayer
    ): Set<TaskUnit> =
        convertTaskUnits(particleSets, scheduler, receivers.toSet())

    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit>

    fun spawnParticle(
        particleSets: Set<IConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
    )

    fun spawnParticle(particleSets: Set<IConfiguredParticleSet>, receivers: Set<IPlayer>)
    fun spawnParticle(particleSets: Set<IConfiguredParticleSet>, vararg receivers: IPlayer) =
        spawnParticle(particleSets, receivers.toSet())

    fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<IPlayer>
}