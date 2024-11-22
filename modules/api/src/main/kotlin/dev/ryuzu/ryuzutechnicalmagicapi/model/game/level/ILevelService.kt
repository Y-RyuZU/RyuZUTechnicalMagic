package dev.ryuzu.ryuzutechnicalmagicapi.model.game.level

import dev.ryuzu.ryuzutechnicalmagicapi.model.game.player.IGamePlayer

interface ILevelService {
    fun selectMission(player: IGamePlayer, mission: LevelUpMission)
    fun checkNorma(player: IGamePlayer)
    fun getLevelData(player: IGamePlayer): LevelData
}