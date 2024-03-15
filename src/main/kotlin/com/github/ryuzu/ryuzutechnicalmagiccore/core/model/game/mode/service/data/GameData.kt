package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.service.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.TeamProperty
import java.util.*

sealed class GameData(
    open val gameMode: GameMode,
    open val stage: String,
) {
    sealed class TeamGameData(
        override val gameMode: GameMode,
        override val stage: String,
        val teams: List<GameTeam> = mutableListOf()
    ) : GameData(gameMode, stage) {
        data class CarryTNTData(
            override val stage: String,
            var holdTeam: TeamProperty? = null,
            var holdPlayer: UUID? = null
        ) : TeamGameData(GameMode.CARRY_TNT, stage)
    }

    data class BattleRoyaleData(
        override val stage: String,
        val phase: Int = 0,
    ) : GameData(GameMode.BATTLE_ROYALE, stage)
}