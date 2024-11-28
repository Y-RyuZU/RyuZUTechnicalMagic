package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface IParticleService {
    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        receivers: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>
    ): Set<TaskUnit>

    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        vararg receivers: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
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

    fun spawnParticle(particleSets: Set<IConfiguredParticleSet>, receivers: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun spawnParticle(particleSets: Set<IConfiguredParticleSet>, vararg receivers: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) =
        spawnParticle(particleSets, receivers.toSet())

    fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>
}