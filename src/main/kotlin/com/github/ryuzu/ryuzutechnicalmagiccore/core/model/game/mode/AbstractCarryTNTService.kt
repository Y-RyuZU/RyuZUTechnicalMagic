package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTNTPlayer.CarryTNTPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam

abstract class AbstractCarryTNTService(
    override val players: MutableSet<IGamePlayer>,
    teamsProperties: Set<ConfiguredTeam>,
) : ICarryTNTService, AbstractTeamGameService(players, teamsProperties) {

    override fun carryTNT(team: IGameTeam.CarryTNTTeam, player: CarryTNTPlayer) {

    }


}