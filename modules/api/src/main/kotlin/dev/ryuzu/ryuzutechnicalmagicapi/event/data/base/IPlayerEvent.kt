package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer


interface IPlayerEvent : IEntityEvent {
    val player: IPlayer
}