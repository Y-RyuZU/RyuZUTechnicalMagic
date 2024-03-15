package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.GamePlayer

sealed interface GameTeam{
    val property: TeamProperty
    val players: MutableList<GamePlayer>

    sealed interface ScoreGameTeam : GameTeam {
        override val property: TeamProperty
        var score: Int
        data class CaptureWool(
            override val property: TeamProperty,
            override var score: Int = 0,
            override val players: MutableList<GamePlayer> = mutableListOf(),
            var captureArea: Byte = 0,
        ) : ScoreGameTeam
    }

    data class CarryTNTTeam(
        override val property: TeamProperty,
        override val players: MutableList<GamePlayer> = mutableListOf(),
    ) : GameTeam
}