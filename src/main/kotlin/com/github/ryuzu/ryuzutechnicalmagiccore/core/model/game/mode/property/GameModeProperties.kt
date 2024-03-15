package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.property

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredLocation

sealed interface GameModeProperty {
    val duration: Int
    val starLostRate: Double


    data class CarryTNTProperty(
        override val duration: Int,
        override val starLostRate: Double,
        val tntSpawnPoint: ConfiguredLocation,
    ) : GameModeProperty
}