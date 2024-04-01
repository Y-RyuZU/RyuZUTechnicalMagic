package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.PlayerDeathEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.ConfiguredGameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.IConfiguredGameModeParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.IConfiguredStageGameModeProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward.ConfiguredReward
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.IEntryGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.AbstractGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.Player
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.reward.IRewardService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar.IBossBarService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import org.koin.core.component.inject
import java.util.*
import kotlin.collections.HashMap

class GameServiceImpl(
    world: String,
    config: ConfiguredGameMode,
    stage: ConfiguredStage,
    entryService: IEntryGameService,
    entryPlayers: Set<IPlayer>,
) : AbstractGameService(world, config, stage, entryService, entryPlayers), IEventHandler {
    private val rewardService: IRewardService by inject()
    private val bossBarService: IBossBarService by inject()

    private val rewards: Map<String, ConfiguredReward> by inject()

    override val gameData: IGameData =
        throw IllegalStateException("This property must be implemented by a subclass.")

    override fun createPlayer(player: IPlayer): IGamePlayer =
        throw IllegalStateException("This method must be implemented by a subclass.")

    override fun getPhase(): Int = throw IllegalStateException("This method must be implemented by a subclass.")
    override fun createBossBar() {
        throw IllegalStateException("This method must be implemented by a subclass.")
    }

    override fun createScoreBoard() {
        throw IllegalStateException("This method must be implemented by a subclass.")
    }

    override val gameModeParameter: IConfiguredGameModeParameter =
        throw IllegalStateException("This method must be implemented by a subclass.")
    override val gameModeProperty: IConfiguredStageGameModeProperty =
        throw IllegalStateException("This method must be implemented by a subclass.")

    override fun respawnPlayer(player: IPlayer) =
        throw IllegalStateException("This method must be implemented by a subclass.")

    override fun start() {
        messageService.sendMessage(config.display.description, players)
        config.effects.sounds["START"]?.let { soundService.playSound(it, players) }
    }

    override fun end() {
        sendGameResultMessage()
        rewards["GameEnd"]?.let { rewardService.giveReward(it, players) }
    }

    override fun joinGameMidway(player: IPlayer) {
        messageService.sendMessage(config.display.description, players)
        config.effects.sounds["START"]?.let { soundService.playSound(it, players) }
    }

    override fun leaveGame(player: IPlayer) {
        removePlayerFromGame(player)
    }

    private fun removePlayerFromGame(player: IPlayer) {
        players.remove(getGamePlayer(player))
    }

    private fun sendGameResultMessage() {

    }

    @EventHandler(priority = 150)
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val gamePlayer = getGamePlayer(event.player)
        gamePlayer.death++
        generatorService.generateStar(
            locationService.getIntLocation(gamePlayer).toDoubleLocation(),
            (gamePlayer.star * stage.gameProperty.starLostRate).toInt(),
            parameter.generatorParameter.starLostScatter * event.lastDamage
        )
        gamePlayer.star *= (1.0 - stage.gameProperty.starLostRate).toInt()

        val respawnInterval = 5L
        schedulerFactory.createScheduler().schedule { _, count ->
            gameModeService.changeGameMode(3, gamePlayer, true)
            titleService.sendTitle(null, "Respawn in ${respawnInterval - count}", gamePlayer)
        }.schedule(respawnInterval) { _, _ ->
            gameModeService.changeGameMode(0, gamePlayer, false)
            respawnPlayer(gamePlayer)
        }
        event.shouldNotify = false
    }
}