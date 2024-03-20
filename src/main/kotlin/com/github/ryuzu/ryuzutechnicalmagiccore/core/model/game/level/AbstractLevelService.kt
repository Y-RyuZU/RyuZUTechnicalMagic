package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.level.LevelUpMission.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

abstract class AbstractLevelService: ILevelService {
    private val normaTable: Map<LevelUpMission, Map<Int, Int>> by inject()
    private val levelMap: MutableMap<IActivePlayer, LevelData> = mutableMapOf()

    override fun selectMission(player: IActivePlayer, mission: LevelUpMission) {
        val levelData = levelMap[player] ?: LevelData(mission, 1, getNorma(player, 1, mission))
        levelMap[player] = LevelData(mission, levelData.level, getNorma(player, levelData.level, mission))
    }

    override fun checkNorma(player: IActivePlayer) {
        val data = getLevelData(player)

        if (canLevelUp(player)) {
            levelMap[player] = data.copy(level = data.level + 1, norma = getNorma(player, data.level + 1, data.mission))
            successLevelUpEffect(data)
        } else
            failLevelUpEffect(data)
    }

    override fun getLevelData(player: IActivePlayer): LevelData =
        levelMap[player] ?: throw IllegalArgumentException("Player not found")

    private fun getNorma(player: IActivePlayer, level: Int, norma: LevelUpMission): Int =
        normaTable[norma]?.get(level) ?: 1

    private fun canLevelUp(player: IActivePlayer): Boolean {
        val levelData = getLevelData(player)
        return levelData.norma <= getCurrentNorma(player)
    }

    private fun getCurrentNorma(player: IActivePlayer): Int {
        return when (levelMap[player]?.mission) {
            STAR -> player.star
            KILL -> player.kill
            null -> TODO()
        }
    }

    protected abstract fun failLevelUpEffect(data: LevelData)
    protected abstract fun successLevelUpEffect(data: LevelData)
}