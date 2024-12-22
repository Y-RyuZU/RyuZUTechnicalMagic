package dev.ryuzu.ryuzutechnicalmagic.api.game.service.team

import dev.ryuzu.ryuzutechnicalmagic.api.game.data.team.SerTeam
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.player.ITeamGamePlayer

sealed interface IGameTeam {
    val property: SerTeam
    val players: MutableSet<ITeamGamePlayer>

}

sealed interface IScoreGameTeam : IGameTeam {
    var score: Int

}

data class CarryTntTeam(
    override val property: SerTeam,
    override val players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
    override var score: Int = 0,
) : IScoreGameTeam

data class CaptureWool(
    override val property: SerTeam,
    override val players: MutableSet<ITeamGamePlayer> = mutableSetOf(),
    override var score: Int = 0,
    var captureArea: Byte = 0,
) : IScoreGameTeam