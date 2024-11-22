package dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode

import dev.ryuzu.ryuzutechnicalmagicapi.model.game.team.IGameTeam
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.player.IGamePlayer

sealed interface IGameData{
    val gameMode: GameMode
    var time: Long

    sealed interface ITeamGameData : IGameData {
        override val gameMode: GameMode
        val teams: List<IGameTeam>
        data class CarryTntData(
            override val gameMode: GameMode = GameMode.CarryTnt,
            override var time: Long = 0,
            override val teams: List<IGameTeam> = mutableListOf(),
            var holdPlayer: IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer? = null
        ) : ITeamGameData
    }

    data class BattleRoyaleData(
        override val gameMode: GameMode = GameMode.BattleRoyale,
        override var time: Long = 0,
        val phase: Int = 0,
    ) : IGameData
}