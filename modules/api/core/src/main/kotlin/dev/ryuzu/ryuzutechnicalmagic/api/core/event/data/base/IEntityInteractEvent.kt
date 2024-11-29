package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import java.util.*


interface IEntityInteractEvent : IEntityEvent {
    var interactor: UUID
}