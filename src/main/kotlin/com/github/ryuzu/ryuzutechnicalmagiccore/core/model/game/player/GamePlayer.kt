package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.GameTeam
import java.util.*

sealed class GamePlayer(
    open val id: UUID,
) {
    sealed class ActivePlayer(
        override val id: UUID,
        var star: Int = 0,
        var kill: Int = 0,
        var death: Int = 0,
    ) : GamePlayer(id = id) {
        sealed class TeamGamePlayer(
            override val id: UUID,
            var assist: Int = 0,
        ) : ActivePlayer(id = id) {
            lateinit var team : GameTeam

            class CarryTNTPlayer(
                override val id: UUID,
            ) : TeamGamePlayer(id = id)

            class CarryMiniTNTPlayer(
                override val id: UUID,
                var holdTNTAmount: Int = 0,
            ) : TeamGamePlayer(id = id)

        }

        data class BattleRoyalePlayer(
            override val id: UUID,
        ) : ActivePlayer(id = id)
    }
}