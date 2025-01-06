package service

import data.skill.SerSkillParams
import data.skill.SerSkillSet
import data.skill.SkillTrigger
import event.data.IEntitySkillCastEvent
import event.data.ISkillActivateEvent

interface ISkillService {
    fun use(event: ISkillActivateEvent)
    fun addState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, state: SkillState)
    fun getSkillIds(itemId: String, skillTrigger: SkillTrigger): List<String>?
    fun getFirstSkillIds(itemId: String, skillTrigger: SkillTrigger): Set<String>?
    fun getSkillSetIdsFromState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, skillTrigger: SkillTrigger): List<String>?
    fun transitionState(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, event: IEntitySkillCastEvent)
    fun clearStates(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun bindSkillToItem(itemId: String, skillSet: SerSkillSet)
    fun registerSkill(skillId: String, skillParams: SerSkillParams)
    fun reloadSkill()
    fun reloadSkillSet()
}