package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.team

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.team.ConfiguredTeam
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer

sealed interface IGameTeam{
    val property: ConfiguredTeam
    val players: MutableSet<ITeamGamePlayer>

    sealed interface IScoreGameTeam : IGameTeam {
        var score: Int

        data class CaptureWool(
            override val property: ConfiguredTeam,
            override val players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
            override var score: Int = 0,
            var captureArea: Byte = 0,
        ) : IScoreGameTeam

        data class CarryTntTeam(
            override val property: ConfiguredTeam,
            override val players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
            override var score: Int = 0,
        ) : IScoreGameTeam
    }
}