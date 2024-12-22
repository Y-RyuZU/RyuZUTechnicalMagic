package dev.ryuzu.ryuzutechnicalmagic.api.game.service.level

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer

interface ILevelService {
    fun selectMission(player: IGamePlayer, mission: dev.ryuzu.ryuzutechnicalmagic.api.game.service.level.LevelUpMission)
    fun checkNorma(player: IGamePlayer)
    fun getLevelData(player: IGamePlayer): dev.ryuzu.ryuzutechnicalmagic.api.game.service.level.LevelData
}