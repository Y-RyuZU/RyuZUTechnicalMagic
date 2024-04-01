package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.gamemode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.entity.IEntityService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode.AbstractGameModeService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode.IGameModeService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.GameMode
import org.koin.core.annotation.Single
import java.util.*

@Single([IGameModeService::class])
class GameModeService : AbstractGameModeService() {
    override fun changeGameMode(gameMode: Int, player: IPlayer) {
        player.toPlayer().gameMode = GameMode.getByValue(gameMode)!!
    }
}