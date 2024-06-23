package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEntityEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ILivingEntityEvent
import java.util.*

interface IEntitySkillDamageEvent : IEntityDamageEvent {
    val skillSetId: String
    val skillId: String?
}