package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer
import java.util.UUID


sealed interface Initiator {
    val id: UUID

    data class EntityCaster(override val id: UUID) : Initiator
    data class PlayerCaster(override val id: UUID) : Initiator
    data class GamePlayerCaster(val player: IGamePlayer, override val id: UUID = player.id) : Initiator
    data class TeamGamePlayerCaster(val player: ITeamGamePlayer, override val id: UUID = player.id) : Initiator
}

sealed interface ISkillEventPrams {
    val location: ConfiguredLocation
    val direction: ConfiguredDoubleVector
    val skillId: String

    data class SkillEventParams(
        override val location: ConfiguredLocation,
        override val direction: ConfiguredDoubleVector
    ) : ISkillEventPrams {
        override lateinit var skillId: String
    }

    sealed interface ICasterEventParams : ISkillEventPrams {
        val initiator: Initiator
        val itemId: String
        val slot: Int

        data class CasterEventParams(
            override val location: ConfiguredLocation,
            override val direction: ConfiguredDoubleVector,
            override val initiator: Initiator,
            override val itemId: String,
            override val slot: Int
        ) : ICasterEventParams {
            override lateinit var skillId: String

            sealed interface IBlockEventParams : ICasterEventParams {
                val block: ConfiguredLocation

                data class BlockEventParams(
                    override val location: ConfiguredLocation,
                    override val direction: ConfiguredDoubleVector,
                    override val initiator: Initiator,
                    override val itemId: String,
                    override val slot: Int,
                    override val block: ConfiguredLocation
                ) : IBlockEventParams {
                    override lateinit var skillId: String
                }
            }

            sealed interface IInteractEventParams : ICasterEventParams {
                val interlocutor: Initiator

                data class InteractEventParams(
                    override val location: ConfiguredLocation,
                    override val direction: ConfiguredDoubleVector,
                    override val initiator: Initiator,
                    override val itemId: String,
                    override val slot: Int,
                    override val interlocutor: Initiator
                ) : IInteractEventParams {
                    override lateinit var skillId: String
                }
            }
        }
    }
}