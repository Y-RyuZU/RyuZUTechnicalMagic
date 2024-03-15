package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.TeamProperty
import java.util.*

abstract class AbstractTeamGameService(
    override val players: MutableSet<GamePlayer>,
    teamsProperties: Set<TeamProperty>,
) : ITeamGameService, AbstractGameService(players) {
    final override val teams: Set<GameTeam> = teamsProperties.map { gameData.gameMode.createTeam(it) }.toSet()

    private fun selectTeamAlgorithm(player: GamePlayer): GameTeam {
        return teams.random()
    }

    override fun joinTeam(player: GamePlayer.ActivePlayer.TeamGamePlayer) {
        val team = selectTeamAlgorithm(player)
        team.players.add(player)
        player.team = team
    }

    override fun leaveTeam(player: GamePlayer.ActivePlayer.TeamGamePlayer) {
        player.team.players.remove(player)
    }

    override fun validatePlayer(player: UUID): GamePlayer.ActivePlayer.TeamGamePlayer {
        val gamePlayer = players.firstOrNull { it.id == player }
        require(gamePlayer is GamePlayer.ActivePlayer.TeamGamePlayer) { "Player must be an instance of GamePlayer.ActivePlayer.TeamGamePlayer" }
        return gamePlayer
    }

    override fun joinGameMidway(player: UUID) {
        super.joinGameMidway(player)
        val gamePlayer = validatePlayer(player)
        joinTeam(gamePlayer)
    }
}