package event.data

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

data class EntitySkillCastEvent(
    val eventProps: ISkillActivateEvent,
    override var livingEntity: ILivingEntity,
    override var entity: IEntity = livingEntity,
) : IEntitySkillCastEvent, ISkillActivateEvent by eventProps