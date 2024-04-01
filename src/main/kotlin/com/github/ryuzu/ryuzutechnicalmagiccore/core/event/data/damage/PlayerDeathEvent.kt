package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

class PlayerDeathEvent(
    eventProps: IEntityDeathEvent,
    override var player: IPlayer
) : IPlayerDeathEvent, IEntityDeathEvent by eventProps