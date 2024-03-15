package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import java.util.UUID

interface ITeamGameService : IGameService {
    val teams: Set<GameTeam>

    fun joinTeam(player: GamePlayer.ActivePlayer.TeamGamePlayer)
    fun leaveTeam(player: GamePlayer.ActivePlayer.TeamGamePlayer)
    fun validatePlayer(player: UUID): GamePlayer.ActivePlayer.TeamGamePlayer
}