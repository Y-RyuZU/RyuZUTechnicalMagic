package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.damage.EntityDeathEvent

interface IGameListener {
    fun unregister()
    fun onPlayerDeath(event: EntityDeathEvent)
}