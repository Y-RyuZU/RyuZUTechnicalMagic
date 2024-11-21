package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity

data class EntitySkillCastEvent(
    val eventProps: ISkillActivateEvent,
    override var livingEntity: ILivingEntity,
    override var entity: IEntity = livingEntity,
) : IEntitySkillCastEvent, ISkillActivateEvent by eventProps