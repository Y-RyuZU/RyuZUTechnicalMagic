package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer

interface ITeamGameService : IGameService {
    override fun getGamePlayer(player: IPlayer): IGamePlayer.GamePlayer.ITeamGamePlayer
    fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean
}