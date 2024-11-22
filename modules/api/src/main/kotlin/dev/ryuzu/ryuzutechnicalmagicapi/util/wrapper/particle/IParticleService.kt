package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.particle

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.TaskUnit

interface IParticleService {
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