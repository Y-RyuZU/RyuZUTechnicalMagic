package dev.ryuzu.ryuzutechnicalmagiccore.model.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.ConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.IBukkitAdapter
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.gamemode.IGameModeService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.location.ILocationService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.message.IMessageService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.message.MessageActionData
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.particle.IParticleService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.sound.ISoundService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.teleport.ITeleportService
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.title.ITitleService
import dev.ryuzu.ryuzutechnicalmagiccore.adapter.entity.IPlayerAdapter
import dev.ryuzu.ryuzutechnicalmagiccore.model.gui.GuiType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Player(
    livingEntity: ILivingEntity
) : IPlayer, ILivingEntity by livingEntity, KoinComponent {
    private val bukkitAdapter: IBukkitAdapter by inject()
    private val teleportService: ITeleportService by inject()
    private val locationService: ILocationService by inject()
    private val messageService: IMessageService by inject()
    private val gameModeService: IGameModeService by inject()
    private val soundService: ISoundService by inject()
    private val titleService: ITitleService by inject()
    private val particleService: IParticleService by inject()
    private val playerAdapter: IPlayerAdapter by inject()

    override fun getName(): String = bukkitAdapter.getName(this)
    override fun isSneaking(): Boolean = bukkitAdapter.isSneaking(this)

    override fun playSound(soundSets: Set<ConfiguredSoundSet>) {
        soundService.playSound(soundSets, this)
    }

    override fun playSound(vararg soundSets: ConfiguredSoundSet) {
        soundService.playSound(soundSets.toSet(), this)
    }

    override fun teleport(location: ConfiguredIntLocation) {
        teleportService.teleport(location, this)
    }

    override fun teleport(vector: ConfiguredIntVector) {
        teleportService.teleport(vector, this)
    }

    override fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData>) {
        messageService.sendMessage(messages, actionPlaceholder, this)
    }

    override fun changeGameMode(gameMode: Int) {
        gameModeService.changeGameMode(gameMode, this)
    }

    override fun changeGameMode(gameMode: Int, lock: Boolean) {
        gameModeService.changeGameMode(gameMode, this, lock)
    }

    override fun sendTitle(title: String?, subtitle: String?) {
        titleService.sendTitle(title, subtitle, this)
    }

    override fun spawnParticle(particleSets: Set<ConfiguredParticleSet>) {
        particleService.spawnParticle(particleSets, this)
    }

    override fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>) {
        playerAdapter.openGui(this, gui, actions)
    }
}