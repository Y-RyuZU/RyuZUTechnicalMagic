package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.team.IGameTeam
import java.util.*

sealed interface IGamePlayer {
    val id: UUID

    data class GamePlayer(
        override val id: UUID,
    ) : IGamePlayer {

        sealed interface IActivePlayer : IGamePlayer {
            var star: Int
            var kill: Int
            var death: Int

            data class ActivePlayer(
                override val id: UUID,
                override var star: Int = 0,
                override var kill: Int = 0,
                override var death: Int = 0,
            ) : IActivePlayer {

                sealed interface ITeamGamePlayer : IActivePlayer {
                    val assist: Int
                    var team: IGameTeam

                    data class TeamGamePlayer(
                        override val id: UUID,
                        override var star: Int = 0,
                        override var kill: Int = 0,
                        override var death: Int = 0,
                        override var assist: Int = 0,
                    ) : ITeamGamePlayer {
                        override lateinit var team: IGameTeam

                        sealed interface ICarryTNTPlayer : ITeamGamePlayer {
                            data class CarryTNTPlayer(
                                override val id: UUID,
                                override var star: Int = 0,
                                override var kill: Int = 0,
                                override var death: Int = 0,
                                override var assist: Int = 0,
                            ) : ICarryTNTPlayer {
                                override lateinit var team: IGameTeam
                            }
                        }

                        sealed interface ICarryMiniTNTPlayer : ITeamGamePlayer {
                            val holdTNTAmount: Int

                            data class CarryMiniTNTPlayer(
                                override val id: UUID,
                                override var star: Int = 0,
                                override var kill: Int = 0,
                                override var death: Int = 0,
                                override var assist: Int = 0,
                                override val holdTNTAmount: Int = 0,
                            ) : ICarryMiniTNTPlayer {
                                override lateinit var team: IGameTeam
                            }
                        }
                    }
                }

                data class BattleRoyalePlayer(
                    override val id: UUID,
                    override var star: Int = 0,
                    override var kill: Int = 0,
                    override var death: Int = 0,
                ) : IActivePlayer
            }
        }
    }
}