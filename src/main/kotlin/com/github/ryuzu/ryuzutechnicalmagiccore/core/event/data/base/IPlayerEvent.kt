package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer


interface IPlayerEvent : IEntityEvent {
    val player: IPlayer
}