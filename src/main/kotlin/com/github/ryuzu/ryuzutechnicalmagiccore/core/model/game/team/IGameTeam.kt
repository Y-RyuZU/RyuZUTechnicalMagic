package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer

sealed interface IGameTeam{
    val property: ConfiguredTeam
    val players: MutableList<IGamePlayer>

    sealed interface IScoreGameTeam : IGameTeam {
        override val property: ConfiguredTeam
        var score: Int

        data class CaptureWool(
            override val property: ConfiguredTeam,
            override var score: Int = 0,
            override val players: MutableList<IGamePlayer> = mutableListOf(),
            var captureArea: Byte = 0,
        ) : IScoreGameTeam
    }

    data class CarryTNTTeam(
        override val property: ConfiguredTeam,
        override val players: MutableList<IGamePlayer> = mutableListOf(),
    ) : IGameTeam
}