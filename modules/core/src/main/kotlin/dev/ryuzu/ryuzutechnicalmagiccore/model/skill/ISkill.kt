package dev.ryuzu.ryuzutechnicalmagiccore.model.skill

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.skill.ConfiguredSkillParams
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.param.ISkillEventPrams
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.service.SkillState
import dev.ryuzu.ryuzutechnicalmagiccore.util.TypedMap

interface ISkill {
    fun use(skillParams: ConfiguredSkillParams, eventParams: ISkillActivateEvent, data: TypedMap, state: SkillState? = null) : () -> TypedMap
}