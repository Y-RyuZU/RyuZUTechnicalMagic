package dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.ConfiguredSkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.service.SkillState

interface ISkill {
    fun use(skillParams: ConfiguredSkillParams, eventParams: ISkillActivateEvent, data: dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap, state: SkillState? = null) : () -> dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap
}