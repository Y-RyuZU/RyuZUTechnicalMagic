package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.active

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team.IActiveTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team.Team
import java.util.*

interface IActiveCarryTNT : IActiveGame {
    val holdTeam: Team?
    val holdPlayer: UUID?

    fun carryTNT(team: IActiveTeam, player: UUID)
}