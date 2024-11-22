package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.effect

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.ConfiguredEffect
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagicapi.model.scheduler.TaskUnit

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