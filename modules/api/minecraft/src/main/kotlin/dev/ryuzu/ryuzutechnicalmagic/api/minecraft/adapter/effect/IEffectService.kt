package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.effect

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.ConfiguredEffect
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.IParticleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.TaskUnit

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
        players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>
    ): Set<TaskUnit>

    fun convertTaskUnits(
        effect: ConfiguredEffect,
        id: String,
        scheduler: IParticleScheduler,
        vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
    ): Set<TaskUnit> = convertTaskUnits(effect, id, scheduler, players.toSet())

    fun playEffect(effect: ConfiguredEffect, id: String, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun playEffect(effect: ConfiguredEffect, id: String, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) =
        playEffect(effect, id, players.toSet())

}