package dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.SkillTrigger
import java.util.*

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
    ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams

    sealed interface ICasterEventParams : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams {
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
        ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams {

            sealed interface IBlockEventParams :
                dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams {
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
                ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IBlockEventParams
            }

            sealed interface IInteractEventParams :
                dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams {
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
                ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IInteractEventParams {
                    sealed interface IDamageByEntityEventParams : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IInteractEventParams,
                        dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams {
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
                        ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IInteractEventParams.InteractEventParams.IDamageByEntityEventParams
                    }
                }
            }

            sealed interface IDamageEventParams :
                dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams {
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
                ) : dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams
            }
        }
    }
}