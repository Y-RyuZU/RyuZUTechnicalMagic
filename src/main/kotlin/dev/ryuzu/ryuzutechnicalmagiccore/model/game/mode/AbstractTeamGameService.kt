package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.mode.ConfiguredGameMode
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.team.ConfiguredTeam
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.team.IGameTeam
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.entry.IEntryGameService
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import java.util.*

abstract class AbstractTeamGameService(
    world: String,
    config: ConfiguredGameMode,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : ITeamGameService, dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.AbstractGameService(world, config, stage, entryService, entryPlayers) {
    protected val teams: LinkedHashMap<String, IGameTeam> =
        stage.teams.associateTo(LinkedHashMap()) { it.id to createGameTeam(it) }

    override fun createPlayer(player: IPlayer): IGamePlayer = throw NotImplementedError()
    override fun getGamePlayer(player: IPlayer): ITeamGamePlayer = throw NotImplementedError()
    protected abstract fun createGameTeam(config: ConfiguredTeam): IGameTeam

    init {
        require(teams.size == 2) { "Team count must be 2" }
        players.forEach { respawnPlayer(it) }
    }

    override fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean {
        val gamePlayer1 = getGamePlayer(player1)
        val gamePlayer2 = getGamePlayer(player2)
        return gamePlayer1.team == gamePlayer2.team
    }

    override fun joinGameMidway(player: IPlayer) {
        super.joinGameMidway(player)
        respawnPlayer(player)
    }

    override fun leaveGame(player: IPlayer) {
        val gamePlayer = getGamePlayer(player)
        leaveTeam(gamePlayer)
        super.leaveGame(player)
    }

    protected fun selectTeamAlgorithm(player: IPlayer): IGameTeam {
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

    override val placeholders: Map<String, () -> String> = buildMap {
        putAll(super.placeholders)
        teams.entries.forEachIndexed { index, entry ->
            put("%team${index}_player_count%") { entry.value.players.size.toString() }
            put("%team${index}_name%") { entry.value.property.name }
            if (entry.value is IGameTeam.IScoreGameTeam) {
                put("%team${index}_score%") { (entry.value as IGameTeam.IScoreGameTeam).score.toString() }
            }
        }
    }
}