package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

interface IGameModeService {
    fun changeGameMode(gameMode: Int, player: IPlayer)
    fun changeGameMode(gameMode: Int, player: IPlayer, lock: Boolean)
    fun isLocked(player: IPlayer): Boolean
}