package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.IBukkitAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.gamemode.IGameModeService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.MessageActionData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.teleport.ITeleportService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.UUID

data class Player(
    override val id: UUID,
) : IPlayer, KoinComponent {
    private val bukkitAdapter: IBukkitAdapter by inject()
    private val teleportService: ITeleportService by inject()
    private val locationService: ILocationService by inject()
    private val messageService: IMessageService by inject()
    private val gameModeService: IGameModeService by inject()
    private val soundService: ISoundService by inject()
    private val titleService: ITitleService by inject()
    private val particleService: IParticleService by inject()

    override fun getName(): String = bukkitAdapter.getName(this)

    override fun playSound(soundSets: Set<ConfiguredSoundSet>) {
        soundService.playSound(soundSets, this)
    }

    override fun Set<IPlayer>.playSound(soundSets: Set<ConfiguredSoundSet>) {
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

    override fun Set<IPlayer>.teleport(location: ConfiguredIntLocation) {
        teleportService.teleport(location, this)
    }

    override fun Set<IPlayer>.teleport(vector: ConfiguredIntVector) {
        teleportService.teleport(vector, this)
    }

    override fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData>) {
        messageService.sendMessage(messages, actionPlaceholder, this)
    }

    override fun Set<IPlayer>.sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData>) {
        messageService.sendMessage(messages, actionPlaceholder, this)
    }

    override fun getIntLocation(): ConfiguredIntLocation {
        return locationService.getIntLocation(this)
    }

    override fun getDoubleLocation(): ConfiguredDoubleLocation {
        return locationService.getDoubleLocation(this)
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

    override fun Set<IPlayer>.sendTitle(title: String?, subtitle: String?) {
        titleService.sendTitle(title, subtitle, this)
    }

    override fun Set<IPlayer>.spawnParticle(particleSets: Set<ConfiguredParticleSet>) {
        particleService.spawnParticle(particleSets, this)
    }

    override fun Set<IPlayer>.spawnParticle(
        particleSets: Set<ConfiguredParticleSet>,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector
    ) {
        particleService.spawnParticle(particleSets, location, vector, this)
    }
}