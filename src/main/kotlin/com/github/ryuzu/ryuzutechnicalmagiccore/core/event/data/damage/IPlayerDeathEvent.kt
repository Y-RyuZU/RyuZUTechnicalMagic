package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IPlayerEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

interface IPlayerDeathEvent : IEntityDeathEvent, IPlayerEvent {
}