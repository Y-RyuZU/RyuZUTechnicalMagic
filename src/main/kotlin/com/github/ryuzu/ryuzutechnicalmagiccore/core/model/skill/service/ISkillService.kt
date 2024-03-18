package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams

interface ISkillService {
    fun use(skillId: String, eventParams: ISkillEventPrams)
    fun use(trigger: SkillTrigger, eventParams: ISkillEventPrams.ICasterEventParams)
    fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet)
    fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams)
    fun reloadSkill(id: String)
    fun reloadAllSkill()
    fun getSkill(id: String, trigger: SkillTrigger): MutableSet<ConfiguredSkillParams>?
}