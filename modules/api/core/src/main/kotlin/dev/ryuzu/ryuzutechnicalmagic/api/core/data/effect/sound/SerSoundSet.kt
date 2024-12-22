package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.sound


import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.Receiver
import kotlinx.serialization.Serializable

@Serializable
data class SerSoundSet(
    val category: String = "MASTER",
    val listenerOnly: Boolean = false,
    val receiver: Receiver = Receiver.ALL,
    val sounds: Set<SerSound> = emptySet()
)
