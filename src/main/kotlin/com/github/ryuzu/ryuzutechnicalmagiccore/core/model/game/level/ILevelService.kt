package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer

interface ILevelService {
    fun selectMission(player: IActivePlayer, mission: LevelUpMission)
    fun checkNorma(player: IActivePlayer)
    fun getLevelData(player: IActivePlayer): LevelData
}