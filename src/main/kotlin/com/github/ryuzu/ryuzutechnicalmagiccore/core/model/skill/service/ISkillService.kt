package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import org.koin.core.component.KoinComponent

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