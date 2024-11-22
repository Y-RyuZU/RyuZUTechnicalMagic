package dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.IEntityEvent
import dev.ryuzu.ryuzutechnicalmagicapi.event.data.base.ILivingEntityEvent
import java.util.*

interface IEntitySkillDamageEvent : IEntityDamageEvent {
    val skillSetId: String
    val skillId: String?
}