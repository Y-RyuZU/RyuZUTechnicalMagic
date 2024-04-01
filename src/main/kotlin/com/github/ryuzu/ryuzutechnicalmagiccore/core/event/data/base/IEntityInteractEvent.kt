package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import java.util.UUID


interface IEntityInteractEvent : IEntityEvent {
    var interactor: UUID
}