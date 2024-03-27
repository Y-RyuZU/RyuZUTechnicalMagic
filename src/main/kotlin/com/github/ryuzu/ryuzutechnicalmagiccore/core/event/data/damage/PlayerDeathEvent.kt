package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

class PlayerDeathEvent(
    eventProps: IPlayerDamageEvent,
) : IPlayerDeathEvent, IPlayerDamageEvent by eventProps