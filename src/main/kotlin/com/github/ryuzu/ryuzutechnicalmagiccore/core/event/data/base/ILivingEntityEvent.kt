package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.ILivingEntity
import java.util.UUID


interface ILivingEntityEvent : IEntityEvent {
    var livingEntity: ILivingEntity
}