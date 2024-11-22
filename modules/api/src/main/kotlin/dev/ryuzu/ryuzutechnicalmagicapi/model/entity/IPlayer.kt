package dev.ryuzu.ryuzutechnicalmagicapi.model.entity

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagicapi.model.gui.GuiType
import dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.message.MessageActionData

interface IPlayer : ILivingEntity {
    fun getName(): String
    fun isSneaking(): Boolean
    fun playSound(vararg soundSets: ConfiguredSoundSet)
    fun playSound(soundSets: Set<ConfiguredSoundSet>)
    fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData> = mapOf())
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<IConfiguredParticleSet.ConfiguredParticleSet>)
    fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}