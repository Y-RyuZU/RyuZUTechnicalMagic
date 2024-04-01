package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer

sealed interface IGameTeam{
    val property: ConfiguredTeam
    val players: MutableSet<ITeamGamePlayer>

    abstract sealed class AbstractScoreGameTeam(
        override val property: ConfiguredTeam,
        var score: Int,
        override val players: MutableSet<ITeamGamePlayer>
    ) : IGameTeam {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as AbstractScoreGameTeam
            if (property != other.property) return false
            return true
        }

        override fun hashCode(): Int {
            return property.hashCode()
        }

        class CaptureWool(
            property: ConfiguredTeam,
            score: Int = 0,
            players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
            var captureArea: Byte = 0,
        ) : AbstractScoreGameTeam(property, score, players)

        class CarryTntTeam(
            property: ConfiguredTeam,
            players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
            score: Int = 0,
        ) : AbstractScoreGameTeam(property, score, players)
    }
}