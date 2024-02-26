package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.player.IGamePlayer

interface IActiveTeam {
    val name: String
    val score: Int
    val players: List<IGamePlayer>
}