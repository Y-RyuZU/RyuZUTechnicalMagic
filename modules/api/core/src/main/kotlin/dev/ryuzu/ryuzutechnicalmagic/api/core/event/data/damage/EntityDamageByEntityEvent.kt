package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

data class EntityDamageByEntityEvent(
    val eventProps: IEntityDamageEvent,
    override val damagerEntity: ILivingEntity,
) : IEntityDamageByEntityEvent, IEntityDamageEvent by eventProps