package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.effect

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.IParticleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.scheduler.TaskUnit

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