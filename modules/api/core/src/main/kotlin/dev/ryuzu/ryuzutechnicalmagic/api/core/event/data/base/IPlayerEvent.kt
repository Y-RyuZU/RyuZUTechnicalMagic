package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base


interface IPlayerEvent : IEntityEvent {
    val player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
}