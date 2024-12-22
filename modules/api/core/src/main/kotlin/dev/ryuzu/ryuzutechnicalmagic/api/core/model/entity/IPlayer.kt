package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.ConfiguredParticleSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.gui.GuiAction
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound.SerSoundSet
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType

interface IPlayer : ILivingEntity {
    fun getName(): String
    fun isSneaking(): Boolean
    fun playSound(vararg soundSets: SerSoundSet)
    fun playSound(soundSets: Set<SerSoundSet>)
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>)
    fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}