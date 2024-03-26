package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.ConfiguredParticleSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.MessageActionData
import java.util.*
import kotlin.collections.HashMap

interface IPlayer {
    val id: UUID

    fun getName(): String
    fun playSound(vararg soundSets: ConfiguredSoundSet)
    fun playSound(soundSets: Set<ConfiguredSoundSet>)
    fun teleport(location: ConfiguredIntLocation)
    fun teleport(vector: ConfiguredIntVector)
    fun sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData> = mapOf())
    fun getIntLocation(): ConfiguredIntLocation
    fun getDoubleLocation(): ConfiguredDoubleLocation
    fun changeGameMode(gameMode: Int)
    fun changeGameMode(gameMode: Int, lock: Boolean)
    fun sendTitle(title: String?, subtitle: String?)
    fun spawnParticle(particleSets: Set<ConfiguredParticleSet>)

    fun Set<IPlayer>.playSound(soundSets: Set<ConfiguredSoundSet>)
    fun Set<IPlayer>.playSound(vararg soundSets: ConfiguredSoundSet) = playSound(soundSets.toSet())
    fun Set<IPlayer>.teleport(location: ConfiguredIntLocation)
    fun Set<IPlayer>.teleport(vector: ConfiguredIntVector)
    fun Set<IPlayer>.sendMessage(messages: List<String>, actionPlaceholder: Map<String, MessageActionData> = mapOf())
    fun Set<IPlayer>.sendTitle(title: String?, subtitle: String?)
    fun Set<IPlayer>.spawnParticle(particleSets: Set<ConfiguredParticleSet>)
    fun Set<IPlayer>.spawnParticle(particleSets: Set<ConfiguredParticleSet>, location: ConfiguredDoubleLocation, vector: ConfiguredDoubleVector)
}