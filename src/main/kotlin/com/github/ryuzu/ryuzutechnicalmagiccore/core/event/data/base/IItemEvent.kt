package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item

interface IItemEvent : IEvent {
    var item: Item
}