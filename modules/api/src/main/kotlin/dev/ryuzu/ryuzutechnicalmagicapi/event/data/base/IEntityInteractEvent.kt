package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import java.util.UUID


interface IEntityInteractEvent : IEntityEvent {
    var interactor: UUID
}