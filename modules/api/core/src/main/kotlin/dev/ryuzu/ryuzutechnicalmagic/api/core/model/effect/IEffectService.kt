package dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.SerEffect
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

interface IEffectService {
    fun convertTaskUnits(
        effect: SerEffect,
        id: String,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit>

    fun playEffect(
        effect: SerEffect,
        id: String,
        location: SerDoubleLocation,
        vector: SerDoubleVector,
        scheduler: IParticleScheduler
    )

    fun convertTaskUnits(
        effect: SerEffect,
        id: String,
        scheduler: IParticleScheduler,
        vararg players: IPlayer
    ): Set<TaskUnit>

    fun playEffect(effect: SerEffect, id: String, vararg players: IPlayer)
}