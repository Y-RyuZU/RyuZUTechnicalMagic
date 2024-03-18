package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.team.ConfiguredTeam
import java.util.*

sealed class GameData(
    open val gameMode: GameMode,
    open val stage: String,
) {
    sealed class TeamGameData(
        override val gameMode: GameMode,
        override val stage: String,
        val teams: List<IGameTeam> = mutableListOf()
    ) : GameData(gameMode, stage) {
        data class CarryTNTData(
            override val stage: String,
            var holdTeam: ConfiguredTeam? = null,
            var holdPlayer: UUID? = null
        ) : TeamGameData(GameMode.CARRY_TNT, stage)
    }

    data class BattleRoyaleData(
        override val stage: String,
        val phase: Int = 0,
    ) : GameData(GameMode.BATTLE_ROYALE, stage)
}