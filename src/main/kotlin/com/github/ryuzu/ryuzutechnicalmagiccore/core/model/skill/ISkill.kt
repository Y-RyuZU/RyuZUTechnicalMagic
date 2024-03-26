package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.SkillState
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

interface ISkill {
    fun use(skillParams: ConfiguredSkillParams, eventParams: ISkillEventPrams, data: TypedMap, state: SkillState? = null) : () -> TypedMap
}