package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

abstract class AbstractGameModeService : IGameModeService {
    private val gameModeChangeLockedMap: MutableMap<IPlayer, Boolean> = mutableMapOf()

    override fun changeGameMode(gameMode: Int, player: IPlayer, lock: Boolean) {
        changeGameMode(gameMode, player)
        gameModeChangeLockedMap[player] = lock
    }
    override fun isLocked(player: IPlayer): Boolean = gameModeChangeLockedMap[player] ?: false
}