package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.level

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.ILevelService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.LevelData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.LevelUpMission
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.LevelUpMission.KILL
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.level.LevelUpMission.STAR
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.StringUtility.Companion.replacePlaceholders
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IEffectService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity.MessageActionData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractLevelService : ILevelService , KoinComponent{
    private val parameter: ConfiguredGeneralParameter by inject()
    private val effectService: IEffectService by inject()
    private val levelMap: MutableMap<IGamePlayer, LevelData> = mutableMapOf()

    override fun selectMission(player: IGamePlayer, mission: LevelUpMission) {
        if (levelMap[player] == null)
            levelMap[player] = LevelData(mission, 1, getNorma(1, mission))
        else {
            val levelData = levelMap[player]!!
            levelMap[player] = LevelData(mission, levelData.level, getNorma(levelData.level, mission))
            effectService.playEffect(parameter.levelParameter.effect, "SelectMission", player)
        }
    }

    override fun checkNorma(player: IGamePlayer) {
        val data = getLevelData(player)

        if (canLevelUp(player)) {
            levelMap[player] = data.copy(level = data.level + 1, norma = getNorma(data.level + 1, data.mission))
            effectService.playEffect(parameter.levelParameter.effect, "SuccessLevelUp", player)

            val placeholders: Map<String, String> = mapOf(
                "%next_star_norma%" to getNorma(data.level + 1, STAR).toString(),
                "%next_kill_norma%" to getNorma(data.level + 1, KILL).toString()
            )

            player.sendMessage(
                parameter.levelParameter.successNormaCheckMessages.replacePlaceholders(placeholders),
                mapOf(
                    parameter.levelParameter.selectStarNormaMessage to MessageActionData({
                        selectMission(
                            player,
                            STAR
                        )
                    }),
                    parameter.levelParameter.selectKillNormaMessage to MessageActionData({
                        selectMission(
                            player,
                            KILL
                        )
                    })
                )
            )
        } else {
            effectService.playEffect(parameter.levelParameter.effect, "FailLevelUp", player)
            player.sendMessage(parameter.levelParameter.failNormaCheckMessages)
        }
    }

    override fun getLevelData(player: IGamePlayer): LevelData =
        levelMap[player] ?: throw IllegalArgumentException("Player not found")

    private fun getNorma(level: Int, mission: LevelUpMission): Int {
        val normaParameter = parameter.levelParameter.normaParameter[level]!!
        return when (mission) {
            STAR -> normaParameter.star
            KILL -> normaParameter.kill
        }
    }

    private fun canLevelUp(player: IGamePlayer): Boolean {
        val levelData = getLevelData(player)
        return levelData.norma <= getCurrentNorma(player)
    }

    private fun getCurrentNorma(player: IGamePlayer): Int {
        return when (levelMap[player]?.mission) {
            STAR -> player.star
            KILL -> player.kill
            null -> TODO()
        }
    }
}