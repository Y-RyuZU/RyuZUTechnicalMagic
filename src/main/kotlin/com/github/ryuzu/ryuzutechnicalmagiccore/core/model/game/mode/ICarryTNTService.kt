package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTNTPlayer.CarryTNTPlayer

interface ICarryTNTService : ITeamGameService {
    fun carryTNT(player: CarryTNTPlayer)

    fun lostTNT(player: CarryTNTPlayer)
}