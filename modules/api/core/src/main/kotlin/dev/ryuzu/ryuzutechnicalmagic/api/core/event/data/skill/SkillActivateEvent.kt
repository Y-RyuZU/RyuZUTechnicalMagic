package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger

data class SkillActivateEvent(
    override var skillCastLocation: ConfiguredDoubleLocation,
    override var direction: ConfiguredDoubleVector,
    override var skillSetId: String,
    override var skillTrigger: SkillTrigger,
    override var skillId: String,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : ISkillActivateEvent, ICancelableEvent by eventProps