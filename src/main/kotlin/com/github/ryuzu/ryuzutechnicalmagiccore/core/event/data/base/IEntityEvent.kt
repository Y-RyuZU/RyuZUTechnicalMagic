package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import java.util.UUID


interface IEntityEvent : IEvent {
    var entity: UUID
}