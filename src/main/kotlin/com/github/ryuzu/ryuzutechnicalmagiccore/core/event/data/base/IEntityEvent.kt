package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import java.util.UUID


interface IEntityEvent : IEvent {
    var entity: IEntity
}