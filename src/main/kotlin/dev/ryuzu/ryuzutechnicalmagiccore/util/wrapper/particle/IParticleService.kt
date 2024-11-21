package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.TaskUnit
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