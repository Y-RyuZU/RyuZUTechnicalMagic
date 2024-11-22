package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.DefaultCancelableEventProperties
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.SkillTrigger

data class SkillActivateEvent(
    override var skillCastLocation: ConfiguredDoubleLocation,
    override var direction: ConfiguredDoubleVector,
    override var skillSetId: String,
    override var skillTrigger: SkillTrigger,
    override var skillId: String,
    val eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.ISkillActivateEvent, ICancelableEvent by eventProps