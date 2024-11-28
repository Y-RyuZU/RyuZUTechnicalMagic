package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity


interface IEntityEvent : IEvent {
    val entity: IEntity
}