package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity

data class EntityDeathByEntityEvent(
    val eventProps: IEntityDeathEvent,
    override val killerEntity: ILivingEntity,
) : IEntityDeathByEntityEvent, IEntityDeathEvent by eventProps