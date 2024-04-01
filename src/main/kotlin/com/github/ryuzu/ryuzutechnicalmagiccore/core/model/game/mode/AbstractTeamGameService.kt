package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

abstract class AbstractTeamGameService(
    world: String,
    config: ConfiguredGameMode,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : ITeamGameService, AbstractGameService(world, config, stage, entryService, entryPlayers) {
    protected val teams: LinkedHashMap<String, IGameTeam> =
        stage.teams.associateTo(LinkedHashMap()) { it.id to createGameTeam(it) }

    override fun createPlayer(player: IPlayer): IGamePlayer = ITeamGamePlayer.TeamGamePlayer(player)
    override fun getGamePlayer(player: IPlayer): ITeamGamePlayer = players.first { it == player } as ITeamGamePlayer
    protected abstract fun createGameTeam(config: ConfiguredTeam): IGameTeam

    init {
        require(teams.size == 2) { "Team count must be 2" }
    }

    override fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean {
        val gamePlayer1 = getGamePlayer(player1)
        val gamePlayer2 = getGamePlayer(player2)
        return gamePlayer1.team == gamePlayer2.team
    }

    override fun start() {
        super.start()
        players.forEach { joinTeam(it as ITeamGamePlayer) }
    }

    override fun joinGameMidway(player: IPlayer) {
        super.joinGameMidway(player)
        val gamePlayer = getGamePlayer(player)
        joinTeam(gamePlayer)
    }

    override fun leaveGame(player: IPlayer) {
        val gamePlayer = getGamePlayer(player)
        leaveTeam(gamePlayer)
        super.leaveGame(player)
    }

    private fun joinTeam(player: ITeamGamePlayer) {
        val team = selectTeamAlgorithm(player)
        team.players.add(player)
        player.team = team
        teleportService.teleport(player.team.property.respawnPoint.toLocation(world), player)
    }

    private fun selectTeamAlgorithm(player: IGamePlayer): IGameTeam {
        algorithmInt++
        return teams[teams.keys.elementAt(algorithmInt % teams.keys.size)]!!
    }
    private var algorithmInt: Int = teams.keys.size

    private fun leaveTeam(player: ITeamGamePlayer) {
        player.team.players.remove(player)
    }

    override fun respawnPlayer(player: IPlayer) {
        val gamePlayer = getGamePlayer(player)
        teleportService.teleport(gamePlayer.team.property.respawnPoint.toLocation(world), player)
    }

    override val placeholders: MutableMap<String, () -> String> = super.placeholders.apply {
        teams.entries.forEachIndexed { index, entry ->
            put("%team${index}_player_count%") { entry.value.players.size.toString() }
            put("%team${index}_name%") { entry.value.property.name }
            if (entry.value is IGameTeam.AbstractScoreGameTeam)
                put("%team${index}_score%") { (entry.value as IGameTeam.AbstractScoreGameTeam).score.toString() }
        }
    }
}