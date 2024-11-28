package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

interface INullableItemEvent : IEvent {
    var item: Item?
}