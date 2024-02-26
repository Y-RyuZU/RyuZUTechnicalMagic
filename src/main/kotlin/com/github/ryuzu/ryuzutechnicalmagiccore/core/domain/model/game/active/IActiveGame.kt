package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.active

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team.IActiveTeam

interface IActiveGame {
    val gameMode: GameMode
    val stage: String
    val teams: List<IActiveTeam>

    // Starts the game, initializes game state and other necessary initial setups.
    fun start()

    // Ends the game, handles cleanup, declares winner etc.
    fun end()

    // Checks whether the game has met its end condition.
    fun checkEnd(): Boolean

    // Renders the current game status to something like a BossBar or ScoreBoard.
    fun renderStatus()

    // Updates the score of a team.
    fun updateScore(team: IActiveTeam, score: Int)

    // Adds a player to the game, does necessary setups like assigning teams.
    fun onPlayerJoin(player: String): IGamePlayer

    // Removes a player from the game, handles necessary cleanups.
    fun onPlayerLeave(player: IGamePlayer)

}