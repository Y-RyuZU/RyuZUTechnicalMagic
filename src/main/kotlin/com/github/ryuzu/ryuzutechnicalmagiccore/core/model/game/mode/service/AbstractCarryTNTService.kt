package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.TeamProperty
import java.util.*

abstract class AbstractCarryTNTService(
    override val players: MutableSet<GamePlayer>,
    teamsProperties: Set<TeamProperty>,
) : ICarryTNTService, AbstractTeamGameService(players, teamsProperties) {

    override fun carryTNT(team: GameTeam.CarryTNTTeam, player: GamePlayer.ActivePlayer.TeamGamePlayer.CarryTNTPlayer) {

    }


}