package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity

class EntitySkillDeathByEntityEvent(
    eventProps: IEntityDeathByEntityEvent,
    override val skillSetId: String,
    override val skillId: String?,
) : IEntitySkillDeathByEntityEvent, IEntityDeathByEntityEvent by eventProps