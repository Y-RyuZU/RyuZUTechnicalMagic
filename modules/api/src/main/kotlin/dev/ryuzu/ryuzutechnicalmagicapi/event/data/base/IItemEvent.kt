package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.storage.Item

interface IItemEvent : IEvent {
    var item: Item
}