package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity


interface IEntityEvent : IEvent {
    val entity: IEntity
}