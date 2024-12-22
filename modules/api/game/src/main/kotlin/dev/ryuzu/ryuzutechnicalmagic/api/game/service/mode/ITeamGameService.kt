package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer

interface ITeamGameService : dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.IGameService {
    override fun getGamePlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): IGamePlayer.GamePlayer.ITeamGamePlayer
    fun isSameTeam(player1: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, player2: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
}