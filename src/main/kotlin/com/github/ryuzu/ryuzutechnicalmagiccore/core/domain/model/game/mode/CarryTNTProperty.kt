package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation

data class CarryTNTProperty(
    override val ducration: Int,
    override val starLostRate: Double,
    val tntSpawnPoint: ConfiguredLocation,
) : IGameModeProperty