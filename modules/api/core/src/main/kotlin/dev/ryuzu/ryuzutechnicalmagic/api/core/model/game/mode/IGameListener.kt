package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.EntityDeathEvent

interface IGameListener {
    fun unregister()
    fun onPlayerDeath(event: EntityDeathEvent)
}