package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity

class EntitySkillCastEvent(
    eventProps: ISkillActivateEvent,
    override var livingEntity: ILivingEntity,
    override var entity: IEntity = livingEntity,
) : IEntitySkillCastEvent, ISkillActivateEvent by eventProps