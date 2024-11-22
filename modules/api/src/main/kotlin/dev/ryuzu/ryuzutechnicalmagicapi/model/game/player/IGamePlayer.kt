package dev.ryuzu.ryuzutechnicalmagicapi.model.game.player

import dev.ryuzu.ryuzutechnicalmagicapi.model.game.team.IGameTeam
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.team.IGameTeam.IScoreGameTeam.CarryTntTeam
import java.util.*

sealed interface IGamePlayer : IPlayer {
    override val id: UUID
    var star: Int
    var kill: Int
    var death: Int

    class GamePlayer(
        player: IPlayer,
        override var star: Int = 0,
        override var kill: Int = 0,
        override var death: Int = 0,
    ) : IGamePlayer, IPlayer by player {
        sealed interface ITeamGamePlayer : IGamePlayer {
            val assist: Int
            val team: IGameTeam

            class TeamGamePlayer(
                player: IPlayer,
                override val team: IGameTeam,
                override var star: Int = 0,
                override var kill: Int = 0,
                override var death: Int = 0,
                override var assist: Int = 0,
            ) : ITeamGamePlayer, IPlayer by player {

                init {
                    team.players.add(this)
                }

                sealed interface ICarryTntPlayer : ITeamGamePlayer {
                    override val team : CarryTntTeam

                    class CarryTntPlayer(
                        player: IPlayer,
                        override val team: CarryTntTeam,
                        override var star: Int = 0,
                        override var kill: Int = 0,
                        override var death: Int = 0,
                        override var assist: Int = 0,
                    ) : ICarryTntPlayer, IPlayer by player
                }

                sealed interface ICarryMiniTntPlayer : ITeamGamePlayer {
                    val holdTNTAmount: Int

                    class CarryMiniTntPlayer(
                        player: IPlayer,
                        override val team: IGameTeam,
                        override var star: Int = 0,
                        override var kill: Int = 0,
                        override var death: Int = 0,
                        override var assist: Int = 0,
                        override val holdTNTAmount: Int = 0,
                    ) : ICarryMiniTntPlayer, IPlayer by player
                }
            }
        }

        class BattleRoyalePlayer(
            player: IPlayer,
            override var star: Int = 0,
            override var kill: Int = 0,
            override var death: Int = 0,
        ) : IGamePlayer, IPlayer by player

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is IGamePlayer) return false
            if (id != other.id) return false
            return true
        }

        override fun hashCode(): Int {
            return id.hashCode()
        }
    }
}