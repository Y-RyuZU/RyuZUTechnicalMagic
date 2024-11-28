package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IConfiguredStageGameModeProperty {
    val starLostRate: Double

    fun getGameMode(): GameMode

    @Serializable
    @SerialName("CarryTnt")
    data class ConfiguredStageCarryTNTProperty(
        override val starLostRate: Double,
        val tntSpawnPoint: ConfiguredIntVector,
        val teamTNTLocations: Map<String, ConfiguredIntVector>
    ) : IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CarryTnt
    }

    @Serializable
    @SerialName("CaptureWool")
    data class ConfiguredStageCaptureWoolProperty(
        override val starLostRate: Double,
        val woolLocations: List<ConfiguredIntVector>,
    ) : IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CaptureWool
    }
}