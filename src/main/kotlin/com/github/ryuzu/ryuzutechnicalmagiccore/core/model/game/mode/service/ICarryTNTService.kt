package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import java.util.*

interface ICarryTNTService : ITeamGameService {
    fun carryTNT(team: GameTeam.CarryTNTTeam, player: GamePlayer.ActivePlayer.TeamGamePlayer.CarryTNTPlayer)
}