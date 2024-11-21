package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import java.util.UUID


interface IEntityInteractEvent : IEntityEvent {
    var interactor: UUID
}