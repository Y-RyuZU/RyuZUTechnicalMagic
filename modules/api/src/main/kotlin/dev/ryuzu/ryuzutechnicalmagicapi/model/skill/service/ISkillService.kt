package dev.ryuzu.ryuzutechnicalmagicapi.model.skill.service

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.IEntitySkillCastEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.skill.ConfiguredSkillParams
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.skill.ConfiguredSkillSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagicapi.model.skill.SkillTrigger

interface ISkillService {
    fun use(event: ISkillActivateEvent)
    fun addState(player: IPlayer, state: SkillState)
    fun getSkillIds(itemId: String, skillTrigger: SkillTrigger): List<String>?
    fun getFirstSkillIds(itemId: String, skillTrigger: SkillTrigger): Set<String>?
    fun getSkillSetIdsFromState(player: IPlayer, skillTrigger: SkillTrigger): List<String>?
    fun transitionState(player: IPlayer, event: IEntitySkillCastEvent)
    fun clearStates(player: IPlayer)
    fun bindSkillToItem(itemId: String, skillSet: ConfiguredSkillSet)
    fun registerSkill(skillId: String, skillParams: ConfiguredSkillParams)
    fun reloadSkill()
    fun reloadSkillSet()
}