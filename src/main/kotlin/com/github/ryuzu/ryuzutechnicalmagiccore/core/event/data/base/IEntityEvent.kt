package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity


interface IEntityEvent : IEvent {
    val entity: IEntity
}