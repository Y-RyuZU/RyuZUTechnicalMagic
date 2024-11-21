package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.effect

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.ConfiguredEffect
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagiccore.model.scheduler.TaskUnit

interface IEffectService {
    fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    ): Set<TaskUnit>

    fun playEffect(
        effect: ConfiguredEffect,
        id: String,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        scheduler: IParticleScheduler
    )

    fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        scheduler: IParticleScheduler,
        players: Set<IPlayer>
    ): Set<TaskUnit>

    fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        scheduler: IParticleScheduler,
        vararg players: IPlayer
    ): Set<TaskUnit> = convertTaskUnits(effect, id, scheduler, players.toSet())

    fun playEffect(effect: ConfiguredEffect, id: String, players: Set<IPlayer>)
    fun playEffect(effect: ConfiguredEffect, id: String, vararg players: IPlayer) =
        playEffect(effect, id, players.toSet())

}