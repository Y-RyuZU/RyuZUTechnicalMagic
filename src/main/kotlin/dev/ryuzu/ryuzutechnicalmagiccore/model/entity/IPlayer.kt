package dev.ryuzu.ryuzutechnicalmagiccore.model.entity

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.set.ConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.message.MessageActionData
import dev.ryuzu.ryuzutechnicalmagiccore.model.gui.GuiType

interface IPlayer : ILivingEntity {
    fun getName(): String
    fun isSneaking(): Boolean
    fun playSound(vararg soundSets: ConfiguredSoundSet)
    fun playSound(soundSets: Set<ConfiguredSoundSet>)
    fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData> = mapOf())
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>)
    fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}