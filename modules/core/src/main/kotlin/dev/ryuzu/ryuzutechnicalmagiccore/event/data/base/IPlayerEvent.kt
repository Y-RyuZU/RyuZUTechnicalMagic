package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer


interface IPlayerEvent : IEntityEvent {
    val player: IPlayer
}