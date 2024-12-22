package dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface IParticleService {
    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        scheduler: IParticleScheduler,
        vararg receivers: IPlayer
    ): Set<TaskUnit>

    fun convertTaskUnits(
        particleSets: Set<IConfiguredParticleSet>,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit>
}