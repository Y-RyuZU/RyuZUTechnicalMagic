package dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.gui.GuiType

interface IPlayer : ILivingEntity {
    fun getName(): String
    fun isSneaking(): Boolean
    fun playSound(vararg soundSets: ConfiguredSoundSet)
    fun playSound(soundSets: Set<ConfiguredSoundSet>)
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<IConfiguredParticleSet.ConfiguredParticleSet>)
    fun openGui(gui: GuiType, actions: Map<GuiAction, () -> Unit>)
}