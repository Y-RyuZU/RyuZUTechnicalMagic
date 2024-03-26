package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillId
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import java.util.UUID

sealed interface ISkillEventPrams {
    val location: ConfiguredIntLocation
    val direction: ConfiguredDoubleVector
    val skillSetId: String
    val skillTrigger: SkillTrigger
    val skillId: String
    data class SkillEventParams(
        override val location: ConfiguredIntLocation,
        override val direction: ConfiguredDoubleVector,
        override val skillSetId: String,
        override val skillTrigger: SkillTrigger,
        override val skillId: String
    ) : ISkillEventPrams

    sealed interface ICasterEventParams : ISkillEventPrams {
        val entity: UUID
        val slot: Int
        data class CasterEventParams(
            override val location: ConfiguredIntLocation,
            override val direction: ConfiguredDoubleVector,
            override val skillSetId: String,
            override val skillTrigger: SkillTrigger,
            override val skillId: String,
            override val entity: UUID,
            override val slot: Int
        ) : ICasterEventParams {

            sealed interface IBlockEventParams : ICasterEventParams {
                val block: ConfiguredIntLocation
                data class BlockEventParams(
                    override val location: ConfiguredIntLocation,
                    override val direction: ConfiguredDoubleVector,
                    override val skillTrigger: SkillTrigger,
                    override val skillSetId: String,
                    override val skillId: String,
                    override val entity: UUID,
                    override val slot: Int,
                    override val block: ConfiguredIntLocation
                ) : IBlockEventParams
            }

            sealed interface IInteractEventParams : ICasterEventParams {
                val interlocutor: UUID
                data class InteractEventParams(
                    override val location: ConfiguredIntLocation,
                    override val direction: ConfiguredDoubleVector,
                    override val skillTrigger: SkillTrigger,
                    override val skillSetId: String,
                    override val skillId: String,
                    override val entity: UUID,
                    override val slot: Int,
                    override val interlocutor: UUID
                ) : IInteractEventParams {
                    sealed interface IDamageByEntityEventParams : IInteractEventParams, IDamageEventParams {
                        data class DamageByEntityEventParams(
                            override val location: ConfiguredIntLocation,
                            override val direction: ConfiguredDoubleVector,
                            override val skillTrigger: SkillTrigger,
                            override val skillSetId: String,
                            override val skillId: String,
                            override val entity: UUID,
                            override val slot: Int,
                            override val interlocutor: UUID,
                            override val amount: Double
                        ) : IDamageByEntityEventParams
                    }
                }
            }

            sealed interface IDamageEventParams : ICasterEventParams {
                val amount: Double
                data class DamageEventParams(
                    override val location: ConfiguredIntLocation,
                    override val direction: ConfiguredDoubleVector,
                    override val skillTrigger: SkillTrigger,
                    override val skillSetId: String,
                    override val skillId: String,
                    override val entity: UUID,
                    override val slot: Int,
                    override val amount: Double
                ) : IDamageEventParams
            }
        }
    }
}