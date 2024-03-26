package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import org.koin.core.component.KoinComponent
import java.util.*

interface ISkillService : KoinComponent {
    fun use(eventParams: ISkillEventPrams)
    fun addState(id: UUID, state: SkillState)
    fun getSkillSetIds(id: UUID, skillTrigger: SkillTrigger): List<String>?
    fun transitionState(id: UUID, eventParams: ISkillEventPrams.ICasterEventParams)
    fun clearStates(id: UUID)
    fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet)
    fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams)
}