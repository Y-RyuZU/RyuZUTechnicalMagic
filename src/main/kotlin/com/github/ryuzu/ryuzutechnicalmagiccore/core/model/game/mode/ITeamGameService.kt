package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

interface ITeamGameService : IGameService {
    fun isSameTeam(player1: IPlayer, player2: IPlayer): Boolean
}