package service

import data.skill.SerSkillParams
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap
import event.data.ISkillActivateEvent

interface ISkill {
    fun use(skillParams: SerSkillParams, eventParams: ISkillActivateEvent, data: TypedMap, state: SkillState? = null) : () -> dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap
}