package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.team.IGameTeam

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