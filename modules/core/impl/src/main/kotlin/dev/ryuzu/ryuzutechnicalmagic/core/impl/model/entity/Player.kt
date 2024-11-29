package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.IBukkitAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.gamemode.IGameModeService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.ISoundService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.teleport.ITeleportService
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.title.ITitleService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Player(
    livingEntity: ILivingEntity
) : IPlayer, ILivingEntity by livingEntity, KoinComponent {
    private val bukkitAdapter: IBukkitAdapter by inject()
    private val teleportService: ITeleportService by inject()
    private val locationService: ILocationService by inject()
//    private val messageService: IMessageService by inject()
    private val gameModeService: IGameModeService by inject()
    private val soundService: ISoundService by inject()
    private val titleService: ITitleService by inject()
    private val particleService: IParticleService by inject()
    private val playerAdapter: dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity.IPlayerAdapter by inject()

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

    override fun teleport(vector: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector) {
        teleportService.teleport(vector, this)
    }

//    override fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData>) {
//        messageService.sendMessage(messages, actionPlaceholder, this)
//    }

    override fun changeGameMode(gameMode: Int) {
        gameModeService.changeGameMode(gameMode, this)
    }

    override fun changeGameMode(gameMode: Int, lock: Boolean) {
        gameModeService.changeGameMode(gameMode, this, lock)
    }

    override fun sendTitle(title: String?, subtitle: String?) {
        titleService.sendTitle(title, subtitle, this)
    }

    override fun spawnParticle(particleSets: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet.ConfiguredParticleSet>) {
        particleService.spawnParticle(particleSets, this)
    }

    override fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>) {
        playerAdapter.openGui(this, gui, actions)
    }
}