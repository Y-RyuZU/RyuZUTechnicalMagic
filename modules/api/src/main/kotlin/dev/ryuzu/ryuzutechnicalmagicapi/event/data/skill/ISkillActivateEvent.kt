package dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.skill.SkillTrigger

interface ISkillActivateEvent: ICancelableEvent {
    var skillCastLocation: ConfiguredDoubleLocation
    var direction: ConfiguredDoubleVector
    var skillSetId: String
    var skillTrigger: SkillTrigger
    var skillId: String
}