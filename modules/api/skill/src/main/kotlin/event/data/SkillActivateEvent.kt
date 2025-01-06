package  event.data

import data.skill.SkillTrigger
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent

data class SkillActivateEvent(
    override var skillCastLocation: SerDoubleLocation,
    override var direction: SerDoubleVector,
    override var skillSetId: String,
    override var skillTrigger: SkillTrigger,
    override var skillId: String,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : ISkillActivateEvent, ICancelableEvent by eventProps