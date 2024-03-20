package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredTeam
import java.util.*

abstract class AbstractTeamGameService(
    override val world: String,
    override val stage: ConfiguredStage,
    entryPlayers: Set<UUID>,
    teamsProperties: Set<ConfiguredTeam>,
) : ITeamGameService, AbstractGameService(world, stage, entryPlayers) {
    private val teams: Set<IGameTeam> = teamsProperties.map { gameData.gameMode.createTeam(it) }.toSet()

    private fun selectTeamAlgorithm(player: IGamePlayer): IGameTeam {
        return teams.random()
    }

    override fun joinTeam(player: ITeamGamePlayer) {
        val team = selectTeamAlgorithm(player)
        team.players.add(player)
        player.team = team
    }

    override fun leaveTeam(player: ITeamGamePlayer) {
        player.team.players.remove(player)
    }

    override fun validatePlayer(player: UUID): ITeamGamePlayer {
        val gamePlayer = players.firstOrNull { it.id == player }
        require(gamePlayer is ITeamGamePlayer) { "Player must be an instance of GamePlayer.ActivePlayer.TeamGamePlayer" }
        return gamePlayer
    }

    override fun joinGameMidway(player: UUID) {
        super.joinGameMidway(player)
        val gamePlayer = validatePlayer(player)
        joinTeam(gamePlayer)
    }
}