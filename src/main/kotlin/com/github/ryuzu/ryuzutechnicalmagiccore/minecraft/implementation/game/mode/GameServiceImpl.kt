package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.IConfiguredStageGameModeProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.AbstractGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.SoundUtility
import org.koin.core.component.inject
import java.util.*

class GameServiceImpl(
    override val world: String,
    override val stage: ConfiguredStage,
    entryPlayers: Set<UUID>,
) : AbstractGameService(world, stage, entryPlayers) {
    private val soundUtility: SoundUtility by inject()

    override val gameData: GameData =
        throw IllegalStateException("This property must be implemented by a subclass.")

    override fun createPlayer(player: UUID): IGamePlayer =
        throw IllegalStateException("This method must be implemented by a subclass.")


    override fun start() {
        sendGameStartMessage()
        playGameStartSound()
    }

    override fun end() {
        sendGameResultMessage()
        returnPlayersToLobby()
        giveRewards()
    }

    override fun canEnd(): Boolean {
        return players.size == 0
    }

    override fun joinGameMidway(player: UUID) {
        sendGameStartMessage()
        playGameStartSound()
    }

    override fun leaveGame(player: IGamePlayer) {
        removePlayerFromGame(player)
        sendPlayerResultMessage(player)
        returnPlayerToLobby(player)
    }

    override fun getPhase(): Int {
        return 0
    }

    override fun onPlayerDeath(player: IGamePlayer) {
        removePlayerFromGame(player)
        sendPlayerResultMessage(player)
        returnPlayerToLobby(player)
    }

    override fun second() {
        renderGameStatus()
    }

    private fun sendGameStartMessage() {
        players.forEach { player ->
            gameModeParameter.display.description.forEach { description ->
                player.id.toPlayer().sendMessage(description)
            }
        }
    }

    private fun playGameStartSound() {
        soundUtility.playSound(gameModeParameter.effects.sounds["START"] ?: setOf(), players)
    }

    private fun sendPlayerResultMessage(player: IGamePlayer) {

    }

    private fun giveRewards() {

    }

    private fun returnPlayersToLobby() {

    }

    private fun removePlayerFromGame(player: IGamePlayer) {

    }

    private fun returnPlayerToLobby(player: IGamePlayer) {

    }

    private fun sendGameResultMessage() {

    }

    private fun renderGameStatus() {

    }
}