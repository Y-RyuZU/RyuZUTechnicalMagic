package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

class PlayerDamageEvent(
    eventProps: IEntityDamageEvent,
    override var player: IPlayer
) : IPlayerDamageEvent, IEntityDamageEvent by eventProps