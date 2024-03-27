package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID


interface IPlayerEvent : IEntityEvent {
    var player: IPlayer
}