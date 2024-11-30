package dev.ryuzu.ryuzutechnicalmagic.core.impl.util.wrapper.gamemode

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.gamemode.IGameModeService

abstract class AbstractGameModeService : IGameModeService {
    private val gameModeChangeLockedMap: MutableMap<IPlayer, Boolean> = mutableMapOf()

    override fun changeGameMode(gameMode: Int, player: IPlayer, lock: Boolean) {
        changeGameMode(gameMode, player)
        gameModeChangeLockedMap[player] = lock
    }
    override fun isLocked(player: IPlayer): Boolean = gameModeChangeLockedMap[player] ?: false
}