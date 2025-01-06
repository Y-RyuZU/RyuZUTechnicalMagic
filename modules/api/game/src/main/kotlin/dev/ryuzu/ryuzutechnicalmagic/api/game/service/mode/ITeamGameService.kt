package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.player.ITeamGamePlayer


interface ITeamGameService : dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.IGameService {
    override fun getGamePlayer(player: IPlayer): ITeamGamePlayer
    fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean
}