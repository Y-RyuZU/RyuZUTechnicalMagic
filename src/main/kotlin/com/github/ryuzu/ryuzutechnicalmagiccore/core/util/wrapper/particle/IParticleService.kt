package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import org.koin.core.component.KoinComponent
import java.util.*

interface IParticleService : KoinComponent {
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vector: ConfiguredDoubleVector, receivers: Set<IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vector: ConfiguredDoubleVector, vararg receivers: IPlayer): Set<TaskUnit> = convertTaskUnits(particleSets, location, vector, receivers.toSet())
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, receivers: Set<IPlayer>): Set<TaskUnit>
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, vararg receivers: IPlayer): Set<TaskUnit> = convertTaskUnits(particleSets, receivers.toSet())
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation): Set<TaskUnit>

    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vector: ConfiguredDoubleVector, receivers: Set<IPlayer>)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vector: ConfiguredDoubleVector, vararg receivers: IPlayer) = spawnParticle(particleSets, location, vector, receivers.toSet())
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, receivers: Set<IPlayer>)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, vararg receivers: IPlayer) = spawnParticle(particleSets, receivers.toSet())
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation)

    fun getReceivers(player: IGamePlayer, location: ConfiguredDoubleLocation): Set<IPlayer>
}