package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.SkillTrigger

interface ISkillActivateEvent: ICancelableEvent {
    var skillCastLocation: ConfiguredDoubleLocation
    var direction: ConfiguredDoubleVector
    var skillSetId: String
    var skillTrigger: SkillTrigger
    var skillId: String
}