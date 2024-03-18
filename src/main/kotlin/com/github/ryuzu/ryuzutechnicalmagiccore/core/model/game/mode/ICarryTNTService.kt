package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTNTPlayer.CarryTNTPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam

interface ICarryTNTService : ITeamGameService {
    fun carryTNT(team: IGameTeam.CarryTNTTeam, player: CarryTNTPlayer)


}