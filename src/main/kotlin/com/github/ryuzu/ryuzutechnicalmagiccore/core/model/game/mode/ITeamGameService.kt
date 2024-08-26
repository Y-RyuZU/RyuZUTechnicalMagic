package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer

interface ITeamGameService : IGameService {
    override fun getGamePlayer(player: IPlayer): IGamePlayer.GamePlayer.ITeamGamePlayer
    fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean
}