package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer
import org.koin.core.component.KoinComponent

interface ILevelService : KoinComponent {
    fun selectMission(player: IActivePlayer, mission: LevelUpMission)
    fun checkNorma(player: IActivePlayer)
    fun getLevelData(player: IActivePlayer): LevelData
}