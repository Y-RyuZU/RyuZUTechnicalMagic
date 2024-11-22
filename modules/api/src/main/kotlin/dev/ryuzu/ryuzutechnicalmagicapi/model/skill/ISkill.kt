package dev.ryuzu.ryuzutechnicalmagicapi.model.skill

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.skill.ConfiguredSkillParams
import dev.ryuzu.ryuzutechnicalmagicapi.model.skill.param.ISkillEventPrams
import dev.ryuzu.ryuzutechnicalmagicapi.model.skill.service.SkillState
import dev.ryuzu.ryuzutechnicalmagicapi.util.TypedMap

interface ISkill {
    fun use(skillParams: ConfiguredSkillParams, eventParams: ISkillActivateEvent, data: TypedMap, state: SkillState? = null) : () -> TypedMap
}