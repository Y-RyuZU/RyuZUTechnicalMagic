package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.gamemode

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IGameModeService {
    fun changeGameMode(gameMode: Int, player: IPlayer)
    fun changeGameMode(gameMode: Int, player: IPlayer, lock: Boolean)
    fun isLocked(player: IPlayer): Boolean
}