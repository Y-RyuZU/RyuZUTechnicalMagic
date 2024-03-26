package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent

interface ILevelService : KoinComponent {
    fun selectMission(player: IGamePlayer, mission: LevelUpMission)
    fun checkNorma(player: IGamePlayer)
    fun getLevelData(player: IGamePlayer): LevelData
}