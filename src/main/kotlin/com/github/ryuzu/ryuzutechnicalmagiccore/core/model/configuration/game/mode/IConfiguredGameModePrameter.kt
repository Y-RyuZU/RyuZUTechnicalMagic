package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredLocation

sealed interface IConfiguredGameModePrameter {
    val duration: Int
    val starLostRate: Int

    data class ConfiguredCarryTNT(
        override val duration: Int,
        override val starLostRate: Int,
        val tntSpawnPoint: ConfiguredLocation,
    ) : IConfiguredGameModePrameter
}