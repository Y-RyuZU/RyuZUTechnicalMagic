package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

interface IItemEvent : IEvent {
    var item: Item
}