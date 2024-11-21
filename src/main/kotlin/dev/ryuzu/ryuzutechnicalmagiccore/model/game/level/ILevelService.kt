package dev.ryuzu.ryuzutechnicalmagiccore.model.game.level

import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent

interface ILevelService : KoinComponent {
    fun selectMission(player: IGamePlayer, mission: LevelUpMission)
    fun checkNorma(player: IGamePlayer)
    fun getLevelData(player: IGamePlayer): LevelData
}