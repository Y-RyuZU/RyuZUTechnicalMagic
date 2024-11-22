package dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode

import dev.ryuzu.ryuzutechnicalmagicapi.event.data.damage.EntityDeathEvent

interface IGameListener {
    fun unregister()
    fun onPlayerDeath(event: EntityDeathEvent)
}