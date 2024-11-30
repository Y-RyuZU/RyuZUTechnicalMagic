package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item

interface IItemEvent : IEvent {
    var item: Item
}