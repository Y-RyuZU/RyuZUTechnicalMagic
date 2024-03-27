package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger

open class SkillActivateEvent(
    override var skillCastLocation: ConfiguredDoubleLocation,
    override var direction: ConfiguredDoubleVector,
    override var skillSetId: String,
    override var skillTrigger: SkillTrigger,
    override var skillId: String,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : ISkillActivateEvent, ICancelableEvent by eventProps