package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector
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
        val tntSpawnPoint: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector,
        val teamTNTLocations: Map<String, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector>
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage.IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CarryTnt
    }

    @Serializable
    @SerialName("CaptureWool")
    data class ConfiguredStageCaptureWoolProperty(
        override val starLostRate: Double,
        val woolLocations: List<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector>,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.stage.IConfiguredStageGameModeProperty {
        override fun getGameMode(): GameMode = GameMode.CaptureWool
    }
}