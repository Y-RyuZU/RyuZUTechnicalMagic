package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import java.util.UUID


interface IEntityInteractEvent : IEntityEvent {
    var interactor: UUID
}