package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

interface INullableItemEvent : IEvent {
    var item: Item?
}