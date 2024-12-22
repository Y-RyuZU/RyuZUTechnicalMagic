package dev.ryuzu.ryuzutechnicalmagic.api.game.data.stage

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface ISerStageGameModeProperty {
    val starLostRate: Double

    fun getGameMode(): GameMode

}

@Serializable
@SerialName("CaptureWool")
data class SerStageCaptureWoolProperty(
    override val starLostRate: Double,
    val woolLocations: List<SerIntVector>,
) : ISerStageGameModeProperty {
    override fun getGameMode(): GameMode = GameMode.CaptureWool
}

@Serializable
@SerialName("CarryTnt")
data class SerStageCarryTNTProperty(
    override val starLostRate: Double,
    val tntSpawnPoint: SerIntVector,
    val teamTNTLocations: Map<String, SerIntVector>
) : ISerStageGameModeProperty {
    override fun getGameMode(): GameMode = GameMode.CarryTnt
}