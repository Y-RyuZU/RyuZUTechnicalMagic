package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEntityEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.ILivingEntity
import java.util.*

class EntitySkillCastEvent(
    eventProps: ISkillActivateEvent,
    override var livingEntity: ILivingEntity,
    override var entity: IEntity = livingEntity,
) : IEntitySkillCastEvent, ISkillActivateEvent by eventProps