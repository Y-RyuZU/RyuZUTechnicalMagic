package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

sealed interface IGamePlayer : IPlayer {
    override val id: UUID
    var star: Int
    var kill: Int
    var death: Int

    data class GamePlayer(
        val player: IPlayer,
        override var star: Int = 0,
        override var kill: Int = 0,
        override var death: Int = 0,
    ) : IGamePlayer, IPlayer by player {
        sealed interface ITeamGamePlayer : IGamePlayer {
            val assist: Int
            var team: IGameTeam

            data class TeamGamePlayer(
                val player: IPlayer,
                override var star: Int = 0,
                override var kill: Int = 0,
                override var death: Int = 0,
                override var assist: Int = 0,
            ) : ITeamGamePlayer, IPlayer by player {
                override lateinit var team: IGameTeam

                sealed interface ICarryTntPlayer : ITeamGamePlayer {
                    data class CarryTntPlayer(
                        val player: IPlayer,
                        override var star: Int = 0,
                        override var kill: Int = 0,
                        override var death: Int = 0,
                        override var assist: Int = 0,
                    ) : ICarryTntPlayer, IPlayer by player {
                        override lateinit var team: IGameTeam
                    }
                }

                sealed interface ICarryMiniTntPlayer : ITeamGamePlayer {
                    val holdTNTAmount: Int

                    data class CarryMiniTntPlayer(
                        val player: IPlayer,
                        override var star: Int = 0,
                        override var kill: Int = 0,
                        override var death: Int = 0,
                        override var assist: Int = 0,
                        override val holdTNTAmount: Int = 0,
                    ) : ICarryMiniTntPlayer, IPlayer by player {
                        override lateinit var team: IGameTeam
                    }
                }
            }
        }

        data class BattleRoyalePlayer(
            val player: IPlayer,
            override var star: Int = 0,
            override var kill: Int = 0,
            override var death: Int = 0,
        ) : IGamePlayer, IPlayer by player
    }
}