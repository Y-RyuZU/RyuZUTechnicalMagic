package dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ICancelableEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.IEntityEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.base.ILivingEntityEvent
import java.util.*

interface IEntitySkillDamageEvent : IEntityDamageEvent {
    val skillSetId: String
    val skillId: String?
}