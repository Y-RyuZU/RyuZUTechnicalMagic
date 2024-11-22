package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IEntity


interface IEntityEvent : IEvent {
    val entity: IEntity
}