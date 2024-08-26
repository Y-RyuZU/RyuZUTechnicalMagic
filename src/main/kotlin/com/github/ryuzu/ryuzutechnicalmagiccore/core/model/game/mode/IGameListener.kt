package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.EntityDeathEvent

interface IGameListener {
    fun unregister()
    fun onPlayerDeath(event: EntityDeathEvent)
}