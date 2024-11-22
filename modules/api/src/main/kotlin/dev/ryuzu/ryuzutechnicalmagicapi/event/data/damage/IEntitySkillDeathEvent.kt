package dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IEntityEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ILivingEntityEvent

interface IEntitySkillDeathEvent : IEntityDeathEvent {
    val skillSetId: String
    val skillId: String?
}