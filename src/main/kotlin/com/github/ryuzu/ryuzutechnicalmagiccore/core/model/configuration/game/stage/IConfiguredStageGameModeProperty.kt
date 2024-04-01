package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "GameMode")
@JsonSubTypes(
    JsonSubTypes.Type(value = IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty::class, name = GameMode.CONST_CARRY_TNT),
    JsonSubTypes.Type(value = IConfiguredStageGameModeProperty.ConfiguredStageCaptureWoolProperty::class, name = GameMode.CONST_CAPTURE_WOOL)
)
sealed interface IConfiguredStageGameModeProperty {
    val starLostRate: Double

    fun getGameMode(): GameMode
    data class ConfiguredStageCarryTNTProperty(
        override val starLostRate: Double,
        val tntSpawnPoint: ConfiguredIntVector,
        val teamTNTLocations: Map<String, ConfiguredIntVector>
    ) : IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CarryTnt
    }

    data class ConfiguredStageCaptureWoolProperty(
        override val starLostRate: Double,
        val woolLocations: List<ConfiguredIntVector>,
    ) : IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CaptureWool
    }
}