package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.EntityDeathEvent

interface IGameListener {
    fun unregister()
    fun onPlayerDeath(event: EntityDeathEvent)
}