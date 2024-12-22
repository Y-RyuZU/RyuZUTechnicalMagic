package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode

import dev.ryuzu.ryuzutechnicalmagic.api.game.service.player.ICarryTntPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.team.IGameTeam

sealed interface IGameData{
    val gameMode: GameMode
    var time: Long
}

sealed interface ITeamGameData : IGameData {
    override val gameMode: GameMode
    val teams: List<IGameTeam>
}

data class BattleRoyalData(
    override val gameMode: GameMode = GameMode.BattleRoyale,
    override var time: Long = 0,
    val phase: Int = 0,
) : IGameData

data class CarryTntData(
    override val gameMode: GameMode = GameMode.CarryTnt,
    override var time: Long = 0,
    override val teams: List<IGameTeam> = mutableListOf(),
    var holdPlayer: ICarryTntPlayer? = null
) : ITeamGameData