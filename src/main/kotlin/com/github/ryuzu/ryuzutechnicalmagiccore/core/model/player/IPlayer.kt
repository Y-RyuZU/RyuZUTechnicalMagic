package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.set.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.MessageActionData

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
}