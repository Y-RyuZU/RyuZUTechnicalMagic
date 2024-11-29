package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.effect.sound.ConfiguredSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType

interface IPlayer : ILivingEntity {
    fun getName(): String
    fun isSneaking(): Boolean
    fun playSound(vararg soundSets: ConfiguredSoundSet)
    fun playSound(soundSets: Set<ConfiguredSoundSet>)
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.effect.particle.set.IConfiguredParticleSet.ConfiguredParticleSet>)
    fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}