package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.DefaultCancelableEventProperties
import  dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import  dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import  dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import  dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import  dev.ryuzu.ryuzutechnicalmagicapi.model.skill.SkillTrigger

data class SkillActivateEvent(
    override var skillCastLocation: ConfiguredDoubleLocation,
    override var direction: ConfiguredDoubleVector,
    override var skillSetId: String,
    override var skillTrigger: SkillTrigger,
    override var skillId: String,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : ISkillActivateEvent, ICancelableEvent by eventProps