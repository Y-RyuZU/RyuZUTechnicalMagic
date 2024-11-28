package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.gamemode

interface IGameModeService {
    fun changeGameMode(gameMode: Int, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun changeGameMode(gameMode: Int, player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer, lock: Boolean)
    fun isLocked(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
}