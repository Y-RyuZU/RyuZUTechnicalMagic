package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger

interface ISkillActivateEvent: ICancelableEvent {
    var skillCastLocation: ConfiguredDoubleLocation
    var direction: ConfiguredDoubleVector
    var skillSetId: String
    var skillTrigger: SkillTrigger
    var skillId: String
}