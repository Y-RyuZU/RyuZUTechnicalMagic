package dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.service

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.ConfiguredSkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.skill.ConfiguredSkillSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger

interface ISkillService {
    fun use(event: ISkillActivateEvent)
    fun addState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, state: SkillState)
    fun getSkillIds(itemId: String, skillTrigger: SkillTrigger): List<String>?
    fun getFirstSkillIds(itemId: String, skillTrigger: SkillTrigger): Set<String>?
    fun getSkillSetIdsFromState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillTrigger: SkillTrigger): List<String>?
    fun transitionState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, event: IEntitySkillCastEvent)
    fun clearStates(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet)
    fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams)
    fun reloadSkill()
    fun reloadSkillSet()
}