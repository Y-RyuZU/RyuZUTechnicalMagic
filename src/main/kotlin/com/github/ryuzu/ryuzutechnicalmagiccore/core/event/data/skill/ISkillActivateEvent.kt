package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger

interface ISkillActivateEvent: ICancelableEvent {
    var skillCastLocation: ConfiguredDoubleLocation
    var direction: ConfiguredDoubleVector
    var skillSetId: String
    var skillTrigger: SkillTrigger
    var skillId: String
}