package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IEntityEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ILivingEntityEvent

interface IEntitySkillDeathEvent : dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.IEntityDeathEvent {
    val skillSetId: String
    val skillId: String?
}