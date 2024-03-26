package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

interface ITeamGameService : IGameService {
    fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean
}