package event.data

import data.skill.SkillTrigger
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent

interface ISkillActivateEvent: ISkillEvent, ICancelableEvent {
    var skillCastLocation: SerDoubleLocation
    var direction: SerDoubleVector
    var skillTrigger: SkillTrigger
}