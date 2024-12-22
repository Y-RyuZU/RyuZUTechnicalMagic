package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerColor
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerScalableColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
    TODO: Add SCULK_CHARGE, SHRIEK, and VIBRATION
    https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html
 */

@Serializable
sealed interface IConfiguredParticle {
    val id: String
    val count: Int
    val extra: Double
    val offset: SerDoubleVector
    val delay: Long
}

@Serializable
@SerialName("block")
data class ConfiguredBlockParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: SerDoubleVector = SerDoubleVector(),
    override val delay: Long = 0,
    val block: String
) : IConfiguredParticle

@Serializable
@SerialName("color")
data class ConfiguredColorParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: SerDoubleVector = SerDoubleVector(),
    override val delay: Long = 0,
    val color: SerColor,
    val scale: Float = 1.0f
) : IConfiguredParticle

@Serializable
@SerialName("item")
data class ConfiguredItemParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: SerDoubleVector = SerDoubleVector(),
    override val delay: Long = 0,
    val item: String,
    val customModel: Int,
    val enchantmentAura: Boolean = false
) : IConfiguredParticle

@Serializable
@SerialName("particle")
data class ConfiguredParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: SerDoubleVector = SerDoubleVector(),
    override val delay: Long = 0,
) : IConfiguredParticle

@Serializable
@SerialName("transition_color")
data class ConfiguredTransitionColorParticle(
    override val id: String,
    override val count: Int = 1,
    override val extra: Double = 0.0,
    override val offset: SerDoubleVector = SerDoubleVector(),
    override val delay: Long = 0,
    val fromColor: SerScalableColor,
    val toColor: SerColor,
    val size: Float,
) : IConfiguredParticle