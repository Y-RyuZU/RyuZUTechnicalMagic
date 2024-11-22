package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.storage.Item

interface INullableItemEvent : IEvent {
    var item: Item?
}