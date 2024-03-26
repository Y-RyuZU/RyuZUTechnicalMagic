package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

class EntityDeathEvent(
    val player: IPlayer,
) : AbstractCancelableEvent() {
    var lastDamage: Double = 0.0
        set(value) {
            field = getSetter(field, value)
        }
}