package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredTeam
import java.util.*

sealed class GameData(
    open val gameMode: GameMode,
) {
    sealed class TeamGameData(
        override val gameMode: GameMode,
        val teams: List<IGameTeam> = mutableListOf()
    ) : GameData(gameMode) {
        data class CarryTNTData(
            var holdTeam: ConfiguredTeam? = null,
            var holdPlayer: UUID? = null
        ) : TeamGameData(GameMode.CARRY_TNT)
    }

    data class BattleRoyaleData(
        val phase: Int = 0,
    ) : GameData(GameMode.BATTLE_ROYALE)
}