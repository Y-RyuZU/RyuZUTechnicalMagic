package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import org.koin.core.component.KoinComponent
import java.util.*

interface IParticleService : KoinComponent {
    fun convertTaskUnits(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, players: Set<UUID>): Set<TaskUnit>
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, players: Set<UUID>)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vararg players: UUID)
}